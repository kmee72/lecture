//import { element2 } from "./1-element/Element";
// import { element1, element2 } from "./1-element/Element";
//와일드카드 임포트 방식
import * as E from "./1-element/Element";
// import { Hello as H1 } from "./1-element/Element";
//export default인 경우
// import HelloH1 from "./1-element/Element";
import * as Ex from "./1-element/Ex.jsx";

const plist = [
  { id: 1, name: "노트북", price: 8000 },
  { id: 2, name: "스마트폰", price: 9000 },
  { id: 3, name: "맥미니", price: 10000 },
];
function App() {
  //리액트 엘리먼트
  //return element1;
  //return element2;
  //return E.element3;
  //return E.element4;
  //return E.element5;
  // return <E.Hello name="홍길동" />;
  return <E.ConfirmDialog />;

  // 리액트 엘리먼트는 => { element1 } 중괄호로 렌더링하고,
  // 리액트 컴퍼넌트(함수형,클래스형) => <Element1 /> 태그형식으로 렌더링
  // return (
  //   <>
  //     {element1}
  //     {element2}
  //     {E.element3}
  //     <E.ConfirmDialog />
  //   </>
  // );

  //return <Ex.Namecard />;
  //return <Ex.Greeting name="홍길동" age="30" />;
  //return <Ex.ProductList />;
  // return <Ex.ProductListProps products={plist} />;
}
export default App;
