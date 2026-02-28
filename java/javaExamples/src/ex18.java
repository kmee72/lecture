//객체지향프로그래밍(OOP, Objective Oriented Programming)
//    : Java언어의 설계철학이 곧 OOP이다.
//    : 객체(사물,물건,것) 지향(추구한다) 프로그래밍
//    : 모든 사물을 객체로 추상화(모델링)하여 프로그래밍하는 기법.
//    : new 클래스 = 객체 = 함수 + 변수 = 행동 + 속성
//  예) 자동차를 클래스로 만들어 보자
//      속성과 행동으로 구분한다.
//     변수(필드)  함수(메소드)
//     가격=1000원   행동=달린다

//클래스 선언(클래스이름의 첫글자 대문자)
class Car {
  //속성(변수,필드)
  int price = 1000;
  //행동(함수,메소드)
  void run(){
    System.out.println("차가 달린다.");
  }
}
public class ex18 {
  public static void main(String[] args) {
    //클래스로부터 객체를 생성한다.
    //클래스이름(타입) 객체이름 = new 클래스이름=생성자함수();
    Car myCar = new Car();

    //객체(클래스) 안의 변수(멤버변수)에 접근하려면, 점을 찍는다.
    System.out.println(myCar.price);

    //System.out.println(myCar.run()); //void타입의 리턴값을 출력불가
    myCar.run();
  }
}
