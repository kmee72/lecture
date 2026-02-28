//State.jsx
// 리액트의 state 개념
// state는 리액트 컴포넌트에서 동적인 데이터를 관리하기 위해 사용되는 객체입니다.
// 컴포넌트의 상태를 관리하고, 상태가 변경되면 해당 변경 사항이 UI에 반영됩니다.
// 예를 들어, 버튼을 클릭하면 숫자가 증가하거나 입력 폼의 내용을 실시간으로
// 화면에 업데이트하는 것 같은 작업들이 state로 관리됩니다.

// 특징
// 1.동적 데이터 관리: UI에서 사용자가 상호작용하면서 발생하는 동적 데이터를 관리.
// 2.변경 시 자동 렌더링: state가 변경되면 컴포넌트가 자동으로 다시 렌더링됨.
// 3.지역적 관리: 각 컴포넌트는 독립적으로 자신만의 state를 가질 수 있음.
// 4.상태변경함수: 부모 컴포넌트로부터 상태변경함수를 props로 넘겨받아,
//             상태변경을 처리할 수 있음.

//State훅을 객체 구조분해할당으로 가져온다.
import { useState } from "react";

export function Counter() {
  //패턴 : 배열 구조분해할당
  // const [상태변수 상태변경함수] = useState(기본값)
  // let 대신 const를 사용하는 이유 : 상태 변수를 임의로 변경불가
  //  반드시 상태변경함수를 통해서 변경해야 됨.
  // (리액트가 직접 상태를 관리하고 있기에)
  const [count, setCount] = useState(0);
  //count = 1;//불가

  function handleCount() {
    setCount(count + 1);
  }

  return (
    <div>
      <p>{count}</p>
      <button onClick={handleCount}>1씩 증가</button>
      <button
        onClick={() => {
          setCount(count + 1);
        }}
      >
        1씩 증가
      </button>
    </div>
  );
}

//좋아요 버튼 상태 구현
export function LikeButton() {
  const [liked, setLiked] = useState(false);

  function toggleLike() {
    setLiked(!liked);
  }

  return (
    <div>
      <button onClick={toggleLike}>{liked ? "좋아요 취소" : "좋아요"}</button>
    </div>
  );
}

//입력된 텍스트를 화면에 바로 보여주기
// 설명 : 입력 필드에 사용자가 입력한 텍스트를 따로 화면에 보여주기
// 힌트 : onChange이벤트 사용
// 다양한 리액트 이벤트 : onClick, onMouseEnter, onDoubleClick
//                         onChange, onKeyDown, onSubmit(폼태그)
export function TextMirror() {
  const [text, setText] = useState("");

  return (
    <div>
      <input
        type="text"
        value={text}
        placeholder="텍스트를 입력하세요."
        // 이벤트함수는 매개변수로 event객체를 받을 수 있다.
        // e : 이벤트 객체 - 이벤트에 대한 정보를 담고 있다.
        // e.target : 이벤트가 발생한 객체(input객체)
        onChange={(e) => {
          setText(e.target.value);
        }}
      />
      <p>입력된 텍스트: {text}</p>
    </div>
  );
}
