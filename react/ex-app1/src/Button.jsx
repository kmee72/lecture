function Button(props) {
  const style = {
    width: "100px",
    height: "50px",
    // || or연산자를 통한 조건적 렌더링. 기본값 설정.
    color: props.color || "black",
    //color: props.color ? props.color : "black",
    fontWeight: "bold",
    fontSize: "18px",
    backgroundColor: props.bgColor || "red",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    border: "3px solid #555555",
    //width : 테두리 + 패딩 + 컨텐츠 크기로 설정
    boxSizing: "border-box",
    borderRadius: "50px",
    cursor: "pointer",
  };

  // 버튼 클릭 핸들러(이벤트함수, 콜백)
  function handleColor() {
    if (props.onClick) {
      props.onClick();
    }
  }
  // 클릭 이벤트를 받는 곳은 버튼이다.
  return (
    <div onClick={handleColor} style={style}>
      {props.title}
    </div>
  );
}

export default Button;
