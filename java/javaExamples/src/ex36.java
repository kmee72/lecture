//추상화 클래스 abstract class
//     일반클래스 + 가상함수
//가상함수 : 함수의 선언만 있고, 본체(코드정의)가 없음.
//         : 본체는 하위클래스에서 재정의(Override)하여 사용함.

//사용하는 이유
//1. 설계과 구현의 분리
//2. 기능을 정의하고, 구현은 나중에 한다.
//3. 유지관리 차원에서 나중에 기능 추가가 쉽다.(기존 코드 유지)

//추상화 클래스
abstract class Picture {
  //가상함수(추상 메소드)
  abstract void draw(); //선언만 존재
  //일반함수
  void sale(){
    System.out.println("판매한다.");
  }
}
class Picasso extends Picture {
  @Override
  void draw() {
    System.out.println("피카소가 그림을 그린다.");
  }
}
class Mone extends Picture {
  @Override
  void draw() {
    System.out.println("모네가 그림을 그린다.");
  }
}

public class ex36 {
  public static void main(String[] args) {
    Picasso picasso = new Picasso();
    picasso.draw();
    Mone mone = new Mone();
    mone.draw();
  }
}



