//메소드 오버라이딩(Overriding)
//   : 상관관계에서 부모클래스의 메소드를
//     자식클래스에서 재정의하는 것
//   : 부모클래스의 메소드는 무시됨.
class Cable {
  int price = 1000;
  void sale(){
    System.out.println("Cable 판매");
  }
}
class PowerCable extends Cable {
  int price = 2000;
  //메소드 오버라이딩 - 메소드 재정의 - 생략가능
  //컴파일러와 개발자에게 오버라이딩되었음을 알려줌.
  @Override //어노테이션 - 컴파일 지시어
  void sale(){
    System.out.println("PowerCable 판매");
  }
}
public class ex30 {
  public static void main(String[] args) {
    PowerCable powerCable = new PowerCable();
    //자식클래스의 멤버변수가 출력.( 변수 Hiding )
    System.out.println(powerCable.price);
    //자식클래스의 메소드가 실행. ( 메소드 Overriding )
    powerCable.sale();
  }
}
