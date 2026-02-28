// CTRL + / 한줄 주석
// 자바 소스 파일은 확장자가 .java이다.
// 자바는 클래스에서 시작해서 클래스에서 끝난다.
// public : 접근제한자를 모두에게 공개(다른 파일/폴더(패키지) 접근가능).
// class : 클래스 선언 예약어
// ex01 : 사용자 클래스 이름
// { } : block 구분자, 클래스, 함수, 배열 등에 사용.
// static : 정적(static) 변수,함수에 사용한다.
//        : 프로그램 실행시 고정된 주소값을 사용값 사용.
//        : 시작함수(main)나 전역변수, 유틸리티 함수등에 사용.
// void : 함수의 반환값이 없음을 의미한다.
// String[] : 문자열 배열을 의미함.
// args : 매개변수 이름.
//"Hello Java!" : 문자열, 쌍따옴표 사용.
//                단따옴표 'A' 문자한자.
// ; 세미콜론을 반드시 해야 됨.
public class ex01 {
    //Entry Point : 프로그램 시작점
    public static void main(String[] args) {
        //콘솔에 문자열을 출력하는 함수.
        //System클래스(객체).out객체.println함수
        System.out.println("Hello Java!");
    }
}
