public class ex08 {
  public static void main(String[] args) {
    //비교 연산자(결과값이 T/F로 나온다 => 조건식(절))
    // A < B : A가 B보다 작은가?
    // A > B :           큰가?
    // A == B :           같은가?
    // A != B :           같지 않은가?
    // A <= B :           작거나 같은가?  A < B || A == B
    // A >= B :           크거나 같은가?  A > B || A == B

    //논리 연산자
    // AND && : ~이고, ~이면서
    // OR || : ~이거나, ~또는, ~중에 하나이면, ~중에 하나라도
    // NOT ! : ~가 아닌

    // 논리표
    // T && T : T
    // T && F : F
    // F && T : F
    // F && F : F
    System.out.println(true && true);
    System.out.println(true && false);
    System.out.println(false && true);
    System.out.println(false && false);

    // T || T : T
    // T || F : T
    // F || T : T
    // F || F : F
    System.out.println(true || true);
    System.out.println(true || false);
    System.out.println(false || true);
    System.out.println(false || false);

    // !T : F
    // !F : T
    System.out.println(!true);
    System.out.println(!false);

    //연습문제
    //1. 10은 2의 배수인지를 true/false로 출력하시오.
    System.out.println(10 % 2 == 0);
    //2. 10은 4의 배수이면서 2의 배수인지를 true/false로 출력하시오.
    System.out.println(10 % 4 == 0 && 10 % 2 == 0);
    //3. 15는 10이상이면서 20미만인지 true/false로 출력하시오.
    System.out.println(15 >= 10 && 15 < 20);
    //이상 >=
    //이하 <=
    //초과 >
    //미만 <
    //4. 3은 9의 약수이면서 15의 약수인지를 true/false로
    System.out.println(9 % 3 == 0 && 15 % 3 == 0);
  }
}
