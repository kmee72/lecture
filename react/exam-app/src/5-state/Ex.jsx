//  default export, 부분 export
import React, { useState } from "react";

// 연습문제 1: 버튼을 클릭할 때마다 색상 변경하기
// 설명: 버튼을 클릭할 때마다 배경 색상이 빨강, 초록, 파랑으로
//    순차적으로 변경되도록 만드세요.
export function ColorChanger() {
  //배열 구조분해할당
  const [colorIndex, setColorIndex] = useState(0);
  const colors = ["red", "green", "blue"];
  console.log(colorIndex);

  const style = {
    width: "100px",
    padding: "20px",
    backgroundColor: colors[colorIndex],
  };
  function handleColor() {
    let nextColorIndex = colorIndex + 1;
    if (nextColorIndex > 2) {
      nextColorIndex = 0;
    }
    setColorIndex(nextColorIndex);
  }
  return (
    <div style={style}>
      <p>현재 색상: {colors[colorIndex]}</p>
      <button onClick={handleColor}>색상 변경</button>
    </div>
  );
}

// 연습문제 2: 체크박스 상태 관리하기
// 설명: 체크박스를 클릭하면 "ON" 또는 "OFF"라는 텍스트가
//   화면에 표시되도록 만드세요.
// 힌트: onChange, checked 속성을 이용
export function ToggleSwitch() {
  const [isChecked, setIsChecked] = useState(false);

  function handleToggle() {
    setIsChecked(!isChecked);
  }

  return (
    <div>
      <input type="checkbox" checked={isChecked} onClick={handleToggle} />
      <p>{isChecked ? "ON" : "OFF"}</p>
    </div>
  );
}

// 연습문제 3: 숫자 제한 걸기
// 설명: 숫자를 증가시키되, 숫자가 10 이상이면
//   더 이상 증가하지 않도록 제한하세요.
export function LimitCounter() {
  const [count, setCount] = useState(0);

  function handleCount() {
    if (count >= 10) {
      return;
    }
    setCount(count + 1);
  }

  return (
    <>
      <p>현재 숫자: {count}</p>
      <button onClick={handleCount}>증가</button>
      {count >= 10 ? "최대숫자에 도달함." : ""}
      {count >= 10 ? <p>최대숫자에 도달함.</p> : null}
      {/* && 연산자를 이용한 조건적 렌더링 */}
      {count >= 10 && "최대숫자에 도달함."}
    </>
  );
}

// 연습문제 4: 버튼을 클릭할 때마다 리스트에 항목 추가하기
// 설명: 버튼을 클릭하면 입력 필드의 값을 리스트에 추가하고,
//   추가된 항목들을 화면에 표시하세요.
// 힌트: [], ["aaa", "bbb", "ccc"]
export function ItemList() {
  const [items, setItems] = useState(["111", "222"]);
  const [inputValue, setInputValue] = useState("");

  function handleAddItem() {
    setItems([...items, inputValue]);
  }
  return (
    <>
      <input
        type="text"
        value={inputValue}
        onChange={(e) => setInputValue(e.target.value)}
      />
      <button onClick={handleAddItem}>항목 추가</button>
      <ul>
        {items.map((item, index) => {
          return <li key={index}>{item}</li>;
        })}
      </ul>
    </>
  );
}
