import * as E from "./2-jsx/Jsx";
import Library from "./2-jsx/Library";
import * as Ex from "./2-jsx/Ex";

function App() {
  //return <Ex.Hello name="홍길동" />;
  //return <Ex.Sum num1="10" num2={"20"} />;
  //return <Ex.DrinkMachine price={3000} />;
  return <Ex.Greeting hour={18} />;

  // 리액트 엘리먼트는 바로 리턴 가능
  // 단 JSX 태그안에서는 { element } 형식으로 반환.
  // return E.E1;
  // return E.E6;

  // 함수형 컴퍼넌트는 태그형식으로 감싸서 반환한다.
  //return <Library />;
}
export default App;
