public class ex04 {
  public static void main(String[] args) {
    // 형변환 type casting
    // 형변환 공식
    // 1. 작은 정수형 -> 큰 정수형 (문제없음)
    // 2. 큰 정수형 -> 작은 정수형 (표현범위 벗어나면 값잘림, 에러)
    // 3. 실수형 -> 정수형(값잘림, 소숫점 날아감)
    // 4. 정수형 -> 실수형(문제없음)

    // 자동(암묵적) 형변환 : 대입(산술)연산자를 통해 자동으로 형변환 됨.
    // 수동(명시적) 형변환 : 형변환 연산자를 통해 형변환 될때.

    // 자동 형변환
    // 1. 같은 타입끼리
    //   int * int => int
    //   long * long => long
    int a = 10 * 20;
    // int(10) * int(20) => int(200) => int a(200)
    System.out.println("a = " + a);

    // 2. 다른 타입끼리
    //   int * long => long  더 큰 타입으로
    long b = 10 * 20L;
    //   long * float => float
    float c = 10L * 3.14f;

    //큰 타입에서 작은 타입으로 값 대입할 때
    long d = (int)10;
//    int e = 20L; // 값이 잘리므로 대입자체가 안됨.
    int f = (int)20L; // 8바이트 00000...0000020 -> 4바이트 0000...00020

//    int g = 3.14f; // 값이 잘리므로 대입자체가 안됨.
    int h = (int)3.14f;  //강제형변환 3.14 -> 3

    //자바스크립트에서는 typeof연산자 통해서 타입을 확인 가능
    //자바에서 타입확인시
    int i = 10;
    float j = 1.234f;
    double k = 1.234;
    System.out.println(((Object)i).getClass().getSimpleName());
    System.out.println(((Object)j).getClass().getSimpleName());
    System.out.println(((Object)k).getClass().getSimpleName());
  }
}
