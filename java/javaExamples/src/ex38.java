//추상화 클래스와 인터페이스 차이점

//추상화 클래스(일반 클래스)는 다중상속 안됨. 다단계 상속은 가능.
class A {
}
class B extends A {
}
class C extends B {
}
//class D extends A,B,C{
//}
interface IA {
}
interface IB {
}
class IC implements IA, IB {  //다중 상속(구현) 가능
}

//추상화 클래스 1개 상속, 인터페이스 다중 구현
class Superman extends C implements IA, IB {

}

public class ex38 {
  public static void main(String[] args) {

  }
}
