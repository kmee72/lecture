import React from "react";
import Book from "./Book"; //.jsx생략

function Library() {
  return (
    <div>
      <Book name="리액트 기초" price={3000} />
      <Book name="노드JS 기초" price={4000} />
      <Book name="스프링 기초" price={5000} />
    </div>
  );
}
// 오직 하나만 export할때 default 사용
export default Library;
