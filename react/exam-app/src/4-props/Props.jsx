//Props.jsx
// 리액트의 Props 개념
// 1. Props란?
//  a. Props는 **"Properties"**의 줄임말로, 리액트 컴포넌트에 데이터를 전달하는 방법입니다.
//  b. 부모 컴포넌트에서 자식 컴포넌트로 데이터를 전달할 때 사용되며, 읽기 전용입니다.
//    (자식 컴포넌트에서 직접 props를 변경할 수 없습니다.)
//  c. Props는 JSX 속성처럼 작성하며, 컴포넌트 내에서 객체 형태로 접근할 수 있습니다.
// 2. Props의 특징
//  a. 컴포넌트 간 데이터 전달 용도
//  b. 불변성 (읽기 전용, 자식에서 수정할 수 없음)
//  c. 동적 데이터 렌더링 지원(props, state가 변경되면 리렌더링됨)

function DisplayList(props) {
  return (
    <div>
      <h2>{props.title}</h2>
      <ul>
        {props.items.map((item, index) => {
          return <li key={index}>{item}</li>;
        })}
        {props.items.map((item, index) => (
          <li key={index}>{item}</li> //return생략됨.
        ))}
      </ul>
    </div>
  );
}

export function Props1() {
  return (
    <div>
      <DisplayList title="과일목록" items={["사과", "바나나", "포도"]} />
    </div>
  );
}

function Button(props) {
  return <button onClick={props.onClickFunc}>클릭하세요.</button>;
}

export function Props2() {
  //함수형 컴퍼넌트
  function handleClick() {
    //일반 이벤트 핸들링(대응,콜백) 함수
    alert("버튼이 클릭되었습니다.");
  }

  return (
    <div>
      {/* 함수 이름(함수형 변수)만 전달한다. */}
      <Button onClickFunc={handleClick} />
    </div>
  );
}

//기본 props 설정
function Greeting1({ name = "손님" }) {
  return <h1>안녕하세요. {name}님!</h1>;
}
function Greeting2({ name = "손님", ...restProps }) {
  return (
    <h1>
      안녕하세요. {name}님! 나이는 {restProps.age}{" "}
    </h1>
  );
}
function Greeting3(props) {
  const { name = "손님" } = props;
  return (
    <h1>
      안녕하세요. {name} 님! 나이는 {props.age}{" "}
    </h1>
  );
}
export function Props3() {
  return (
    <div>
      <Greeting1 name="홍길동" />
      <Greeting1 />
      <Greeting2 name="홍길동" age={30} />
      <Greeting3 age={30} />
    </div>
  );
}

// 객체 구조분해할당으로 props전달
function Profile({ name, age, job }) {
  return (
    <div>
      <p>이름: {name}</p>
      <p>나이: {age}</p>
      <p>직업: {job}</p>
    </div>
  );
}
export function Props4() {
  const user = {
    name: "김개발",
    age: 28,
    job: "개발자",
  };
  return <Profile {...user} />;
  //return <Profile name={user.name} age={user.age} job={user.job} />;
}

//children으로 props전달하기
function Card(props) {
  return (
    <div>
      <h2>{props.title}</h2>
      {/* children은 props의 기본속성 */}
      {props.children}
    </div>
  );
}
export function Props5() {
  return (
    <Card title="카드 제목">
      <p>카드내용입니다.</p>
      <button>자세히 보기</button>
    </Card>
  );
}
