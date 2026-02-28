// Effect.jsx

// 리액트 컴퍼넌트 라이프사이클(생애주기)의 개념
// 리액트의 라이프사이클은 컴포넌트가 생성되고, 업데이트되며,
// 제거될 때 일어나는 일련의 과정을 의미합니다.
// 클래스형 컴포넌트에서 더 명확하게 사용되었지만,
// 함수형 컴포넌트에서는 useEffect Hook을 통해 비슷한 동작을 구현할 수 있습니다.

// 리액트 컴포넌트 라이프사이클의 3단계
// 1. 마운트 (Mount): 컴포넌트가 처음 DOM에 추가될 때 발생하는 단계
// 2. 업데이트 (Update): 상태나 props가 변경되어 컴포넌트가 다시 렌더링될 때 발생하는 단계
// 3. 언마운트 (Unmount): 컴포넌트가 DOM에서 제거될 때 발생하는 단계

// 클래스형 컴포넌트의 주요 라이프사이클 메서드
// componentDidMount(): 컴포넌트가 처음 렌더링된 후 실행
// componentDidUpdate(): 컴포넌트가 업데이트된 후 실행
// componentWillUnmount(): 컴포넌트가 언마운트(제거)되기 직전에 실행

import React, { Component, useState, useEffect } from "react";

//클래스형 컴퍼넌트의 생애주기 함수
export class LifeCycleClass extends Component {
  //생성자 함수
  constructor(props) {
    super(props); //부모생성자에게 props전달
    this.state = {
      //상태변수 선언
      count: 0,
    };
  }

  //마운트 발생시
  componentDidMount() {
    console.log("컴퍼넌트가 마운트됨.");
  }
  //언마운트 발생시
  componentWillUnmount() {
    console.log("컴퍼넌트가 언마운트 될 예정임");
  }
  //업데이트시(상태나 props변경시)
  componentDidUpdate() {
    console.log("컴퍼넌트가 업데이트됨.");
  }
  render() {
    return (
      <div>
        <h1>리액트 생애주기(클래스형)</h1>
        <p>Count: {this.state.count}</p>
        <button
          onClick={() => {
            this.setState({ count: this.state.count + 1 });
          }}
        >
          +1 증가하기
        </button>
      </div>
    );
  }
}

//함수형 컴퍼넌트에서는 useEffect Hook으로 생애주기
//함수를 사용할 수 있다.
// useEffect( () => {}, [] ); 컴퍼넌트가 마운트될 때 실행됨.
// useEffect( () => {}, [state]); 의존성 배열이 변경될 때 실행됨.
// return () => {}; 언마운트 될때 실행됨.

//함수형 컴퍼넌트
export function LifeCycleFunc() {
  const [count, setCount] = useState(0);

  //마운트 될때 호출되는 함수
  //2번째 매개변수로 빈배열 넣어주면, 마운트/언마운트시에 한번 호출.
  useEffect(() => {
    console.log("마운트 되었음.");
    return () => {
      console.log("언마운트 되었음.");
    };
  }, []);

  //업데이트
  useEffect(() => {
    console.log("컴퍼넌트가 업데이트 됨.");
  }, [count]); //의존성배열에 상태를 넣어줌.

  return (
    <div>
      <h1>리액트 라이프사이클(함수형 컴퍼넌트)</h1>
      <p>Count: {count}</p>
      <button
        onClick={() => {
          setCount(count + 1);
        }}
      >
        +1 증가하기
      </button>
    </div>
  );
}

//부모 컴퍼넌트
export function LifeCycle() {
  const [isShow, setIsShow] = useState(false);

  //조건부 렌더링
  //1. if else
  //2. 삼항연산자
  //3. 논리연산자(&& ||)

  return (
    <div>
      {isShow && <LifeCycleFunc />}
      <button
        onClick={() => {
          setIsShow(!isShow);
        }}
      >
        {isShow ? "컴퍼넌트 제거" : "컴퍼넌트 추가"}
      </button>
    </div>
  );
}
