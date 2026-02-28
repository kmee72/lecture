//클래스를 또 선언하려면, 클래스 밖에서 선언한다.
public class ex17 {
  //함수를 또 선언하려면, 함수 밖에서 선언한다.
  public static void main(String[] args) {
    //함수(Function, Method(클래스 안의 함수, Java))
    // JS와 거의 문법이 유사함.

    myFunc1();
    myFunc2(10);
    int result = myFunc3();
    System.out.println("result = " + result);
    String resultStr =  myFunc4("대한", "민국");
    System.out.println("resultStr = " + resultStr);
  }

  //static함수에서 함수호출시 static을 사용해야 됨.
  //매개변수 X, 반환값 X(void타입 사용)
  static void myFunc1() {
    System.out.println("myFunc1 호출됨.");
    return; //반환값이 없을때(void) return생략 가능.
  }

  //매개변수 O, 반환값 X
  static void myFunc2(int param) {
    //함수의 매개변수와 지역변수는 함수 안에서만 작동한다.
    int localVar = 20;
    System.out.println("myFunc2:" + param);
  }

  //매개변수 X, 반환값 O
  static int myFunc3() {
    //반환타입과 값을 일치시켜야 됨.
    System.out.println("myFunc3 호출됨.");
    return 30;
  }
  //매개변수 O, 반환값 O
  static String myFunc4(String param1, String param2){
    return param1 + param2;
  }
}

class Other {
  //클래스 밖에 선언
}
