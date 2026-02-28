import { useState } from "react";
import "./App.css";

function App() {
  const [num1, setNum1] = useState(0);
  const [num2, setNum2] = useState(0);
  const [result, setResult] = useState(0);

  const handleCalc = (op) => {
    if (op == "add") {
      setResult(Number(num1) + Number(num2));
    } else if (op == "sub") {
      setResult(Number(num1) - Number(num2));
    } else if (op == "mul") {
      setResult(Number(num1) * Number(num2));
    } else if (op == "div") {
      setResult(Number(num1) / Number(num2));
    } else if (op == "clear") {
      setNum1(0);
      setNum2(0);
      setResult("");
    }
  };

  return (
    <div className="wrapper">
      <h1 className="border">React App</h1>
      <h3 className="border">계산기 프로그램을 만들어 보자.</h3>
      <div className="input-box border">
        <label className="label">숫자 1</label>
        <input
          className="input"
          type="text"
          value={num1}
          onChange={(e) => setNum1(e.target.value)}
        ></input>
      </div>
      <div className="input-box border">
        <label className="label">숫자 2</label>
        <input
          className="input"
          type="text"
          value={num2}
          onChange={(e) => setNum2(e.target.value)}
        ></input>
      </div>
      <div className="input-box border">
        <label className="label">연산결과</label>
        <input
          className="input"
          disabled
          type="text"
          value={result}
          onChange={(e) => setResult(e.target.value)}
        ></input>
      </div>
      <div onClick={() => handleCalc("add")} className="button blue">
        덧셈
      </div>
      <div onClick={() => handleCalc("sub")} className="button blue">
        뺄셈
      </div>
      <div onClick={() => handleCalc("mul")} className="button blue">
        곱셈
      </div>
      <div onClick={() => handleCalc("div")} className="button blue">
        나눗셈
      </div>
      <div onClick={() => handleCalc("clear")} className="button red">
        지우기
      </div>
    </div>
  );
}

export default App;
