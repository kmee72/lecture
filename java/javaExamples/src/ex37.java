//인터페이스(Interface)
//     : 가상함수만 존재한다.(일반함수x)

//추상화 클래스와 인터페이스는 둘다 추상메소드(가상함수)를 가진다.
//설계와 구현의 관점을 둘다 가진다.
//            추상화 메소드      인터페이스
//1.가상함수  있음               있음
//2.일반함수  가능               가능
//3.예약어    abstract class     interface
//            abstract 메소드명  abstract생략가능
//            extends(상속)      implements(구현)
//4.다중상속  불가               가능
//            extendes A,B,c     implements A,B,C
//5.접근제한자 public/protected/private  public만 가능
//6.필드 선어 가능               public static만 가능

interface Drawing {
  abstract void draw();
  void stkech(); //abstract 생략가능
  //일반함수 안됨
  //void paint() { }
}
class Painter implements Drawing {
  @Override
  public void draw() {
    System.out.println("드로윙");
  }
  @Override
  public void stkech() {
    System.out.println("스케치");
  }
}

public class ex37 {
  public static void main(String[] args) {
    Painter painter = new Painter();
    painter.draw();
    painter.stkech();
  }
}
