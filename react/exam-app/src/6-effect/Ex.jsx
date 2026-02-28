//Ex.jsx
import React, { useState, useEffect } from "react";
//서버와 JS(React.js)에서 통신을 해보자.
//1. JS : fetch()함수
//2. Axios : axios()함수
//  설치 : npm i(nstall) axios

//연습문제1: API 호출 및 데이터 로드
// 목표: 컴포넌트가 마운트될 때 API 호출을 통해 데이터를 가져와
//    화면에 표시하세요.
// 요구사항:
// 1. URL: https://jsonplaceholder.typicode.com/posts
// 2. 상위 10개의 포스트 테이터만 출력하세요.
// 3. useEffect를 사용하여 컴포넌트가 마운트될 때 데이터를 1번만 로드하세요.
// 4. 데이터를 로드한 후 상태에 저장하고 화면에 출력하세요.
// 힌트: fetch 또는 axios 모듈 사용 가능합니다.

// JS의 fetch함수
export function DataFetchJS() {
  const [data, setData] = useState([]);

  // async/await 구문 : JS에서 비동기적인 처리를 할때 사용하는 예약어.
  // promise/then 구문 : 구조화된 호출과 응답을 위해 처리하는 예약어.
  const fetchData = async () => {
    try {
      const response = await fetch(
        "https://jsonplaceholder.typicode.com/posts",
      );
      console.log(response);
      if (!response.ok) {
        throw new Error("네트워크 응답이 올바르지 않습니다.");
      }

      //response : HTTP통신의 결과값(HTTP헤더+바디(data))
      //json() : JSON형태의 문자열을 json KV객체로 변환해주는 함수.
      const result = await response.json();
      console.log(result.slice(0, 10));
      setData(result.slice(0, 10)); //배열 0번부터 10개만 가져오기
    } catch (error) {
      console.error("데이타 가져오기 실패", error);
    }
  };

  useEffect(() => {
    console.log("DidMount");
    fetchData(); //마운드시에 한번만 호출.
  }, []);

  return (
    <div>
      <h1>fetch 통신으로 가져온 데이터</h1>
      <ul>
        {data.map((post) => (
          <li key={post.id}>{post.title}</li>
        ))}
      </ul>
    </div>
  );
}

// Axios의 axios함수
// 콘솔) npm i axios
import axios from "axios";
export function DataFetchAxios() {
  const [data, setData] = useState([]);

  const fetchData = async () => {
    try {
      const response = await axios.get(
        "https://jsonplaceholder.typicode.com/posts",
      );
      //axios함수의 기본응답이 json 객체형태이다.
      console.log(response.data);
      setData(response.data.slice(0, 10));
    } catch (error) {
      throw new Error("데이터 가져오기 오류", error);
    }
  };

  //의존성배열이 비어있으면,마운트/언마운트시 호출
  useEffect(() => {
    fetchData(); //마운트시 한번만 호출됨.
  }, []);

  return (
    <div>
      <h1>axios 통신으로 가져온 데이터</h1>
      <ul>
        {data.map((post) => (
          <li key={post.id}>{post.title}</li>
        ))}
      </ul>
    </div>
  );
}

//통신응답으로 반환된 JSON형태의 문자열
// [
// {
//   "userId": 1,
//   "id": 1,
//   "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//   "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
// },
// ]

//JS 객체
// [
// {
//   userId : 1,
//   id: 1,
//   title: "sunt aut facere repel",
//   body : "quia et suscip"
// },
// {},
//]

//예제 - 윈도우 크기 변경 감지
// 목표: 윈도우의 크기가 변경될 때마다
//     현재 창의 너비를 화면에 표시하세요.
// 요구사항:
//   useEffect로 이벤트 리스너를 등록하고
//      창 크기가 변경될 때마다 상태를 업데이트하세요.
//   언마운트 시 이벤트 리스너를 해제하세요.
// 힌트: window.addEventListener와 window.removeEventListener
export function WindowSizeTracker() {
  const [windowWidth, setWindowWidth] = useState(window.innerWidth);
  //JS의 이벤트 리스너를 등록한다 - 마운트시 한번만
  //                     등록해제한다. - 언마운시 한번만
  useEffect(() => {
    const handleResize = () => {
      setWindowWidth(window.innerWidth);
    };

    window.addEventListener("resize", handleResize);

    //언마운트시 리스너 제거
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  return <h1>현재 창의 너비: {windowWidth}px</h1>;
}

// 연습예제 - 타이머 기능 (마운트 및 언마운트)
// 목표: 컴포넌트가 마운트되면 1초마다 상태값이 증가하는 타이머를 시작하고,
//     컴포넌트가 언마운트될 때 타이머를 정리하세요.
// 요구사항:
//   useEffect를 사용하여 마운트 시 타이머를 시작하고, 언마운트 시
//     타이머를 정리하세요.
//   1초마다 상태값을 증가시키세요.
// 힌트: setInterval과 clearInterval 사용
export function Timer() {
  const [seconds, setSeconds] = useState(0);

  useEffect(() => {
    //마운트시 타이머 설정
    const timer = setInterval(() => {
      //일반 업데이트 : 현재 렌더링 시점의 변수 값
      //   : 비동기상황이나 클로저(화살표함수)내부에서 위험함.
      //   : 여러번 호출해도 한번만 반영되는 경우가 발생함.
      //setSeconds(seconds + 1);

      //preState는 이전 상태 값을 가지는 변수.
      //useState 상태변경 함수 안에서 화살표함수의 매개변수로 사용가능함.
      // 왜? 필요한가?
      // prev를 사용하면, React가 보장하는 최신 상태 값에 기반해
      // 안전하게 상태를 업데이트 할 수 있다.
      // 사용예) 카운터,타이머,체크박스 토글
      //        useEffect, setTimeout, setInterval 비동기함수(선언,실행)에서
      //        한 함수내에서 여러번 호출할때.
      // setSeconds
      // setSeconds
      // setSeconds
      setSeconds((preState) => {
        return preState + 1;
      });
    }, 1000);
    //언마운시 타이머 제거
    return () => clearInterval(timer);
  }, []);

  return <h1>타이머 : {seconds}초</h1>;
}
