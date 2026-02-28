// final 키워드
// 1. final 변수 : 상수형 변수
// 2. final class : 상속 불가
// 3. final 메소드 : 오버라이딩 불가
class FinalClass {
  String name = "파이널 클래스";
  int age; //일반변수, 초기값이 없으면 0으로 초기화됨.
  final int price = 1000; //상수형 변수, 초기값 필수!
  final void disp(){ }
}
class LastClass extends FinalClass {
  //final 클래스 ~로부터 상속할 수 없습니다

  // 재정의된 메서드는 final입니다/
  //@Override
  //void disp(){}
}

public class ex32 {
  public static void main(String[] args) {
    System.out.println((new FinalClass()).name);
  }
}
