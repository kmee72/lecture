import { useState } from "react";
import "./App.css";
import Button from "./Button";

function App() {
  const [color, setColor] = useState("red");
  const style = {
    width: "200px",
    height: "350px",
    backgroundColor: color,
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    flexDirection: "column",
    gap: "40px",
    transition: "0.3s",
  };

  return (
    <div style={style}>
      {/* onClick 이벤트에 대응할 함수형변수(화살표함수,코드)를 전달한다. */}
      {/* 화살표함수내에서 실행문이 한줄 -> return {} ; 생략 */}
      {/* 하위 컴퍼넌트로 상태변경함수를 전달하는 구조이다. */}
      <Button onClick={() => setColor("red")} title="빨강" bgColor="red" />
      <Button
        onClick={() => setColor("skyblue")}
        title="파랑"
        bgColor="skyblue"
      />
      <Button
        onClick={() => setColor("darkgray")}
        title="검정"
        color="white"
        bgColor="darkgray"
      />
    </div>
  );
}

export default App;
