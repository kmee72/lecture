import java.util.Random;

public class ex10 {
  public static void main(String[] args) {
    //조건문 = JS와 문법의 거의 유사
    //1. 단순 if문
    if (10 < 20) {
      System.out.println("10은 20보다 작음");
    }
    //실행문이 한줄일 때는 { } 중괄호 생략 가능
    //(조건문,반복문)
    if (10 < 20)
      System.out.println("111");
    //2. if else문
    if (10 > 20) {
      System.out.println("10>20");
    } else {
      System.out.println("10<=20");
    }
    //3. if else if문
    int score = 90;
    if (score >= 90) {
      System.out.println("90이상");
    } else if (score >= 80) {
      System.out.println("80이상");
    } else { //그외의 수
      System.out.println("그외의 수");
    }

    //4. 중첩if문(if문 안의 if문(1,2,3))
    if (true) { //조건1
      if (false) { //조건2
        //조건1이 참이고 조건2가 참일때
      } else if (true) { //조건3
        //조건1이 참이고
        //조건2가 거짓이고
        //조건3이 참일때
      }
    } //if

    //자바에서 랜덤수 발생
    //1. Math.random() 0.0 ~ 0.99999...
    System.out.println((int) (Math.random() * 6));
    //2. Random 클래스 import
    Random rand = new Random();
    int num = rand.nextInt(6); //0~5의 랜덤정수 발생
    System.out.println("num = " + num);

    //연습문제
    //1.
    // 철수와 영희가 주사위 놀이를 하고 있다.
    // 주사위 2개를 던져서,
    // 두개 다 짝수가 나오면 철수 승!
    // 두개 다 홀수가 나오면, 영희 승!
    // 그외의 경우는 무승부! 이다.
    // 게임의 결과를 출력하시오.
    Random rand2 = new Random();
    int dice1 = rand2.nextInt(6) + 1;
    int dice2 = rand2.nextInt(6) + 1;
    System.out.println("dice1 = " + dice1);
    System.out.println("dice2 = " + dice2);
    if (dice1 % 2 == 0 && dice2 % 2 == 0) {
      System.out.println("철수 승!");
    } else if (dice1 % 2 == 1 && dice2 % 2 == 1) {
      System.out.println("영희 승!");
    } else {
      System.out.println("무승부");
    }

    //2.
    //철수와 영희을 주사위게임을 하고 있다.
    //주사위 2개를 철수가 던지고,
    //주사위 2개를 영희도 던진다.
    //게임룰 : 첫번째 주사위는 십의 자릿수로하고,
    //        두번째 주사위는 일의 자릿수로 해서,
    // 더 높은 점수를 가진 사람이 승리한다.
    //출력값 예시 :
    //        철수 주사위1 수 : 1
    //        철수 주사위2 수 : 3
    //        철수의 점수는 13
    //        영희 주사위1 수 : 3
    //        영희 주사위2 수 : 4
    //        영희의 점수는 34
    //        영희 승!
    int dice3 = rand2.nextInt(6) + 1;
    int dice4 = rand2.nextInt(6) + 1;
    System.out.println("dice3 = " + dice3);
    System.out.println("dice4 = " + dice4);
    // 변수,함수,클래스 이름 짓기
    // Java 계열에서는 카멜(Camel) : 예) mySundayEventPoint 길게 풀어서 쓴다.
    // JS, Pyhton 계열에서는 스테이크(Snake) : 예)my_student_event_point
    // 안좋은 이름 예) int a ???, i는 반복변수로,
    int scoreChulsu = dice3 * 10 + dice4;

    int dice5 = rand2.nextInt(6) + 1;
    int dice6 = rand2.nextInt(6) + 1;
    System.out.println("dice5 = " + dice5);
    System.out.println("dice6 = " + dice6);
    int scoreYounghee = dice5 * 10 + dice6;
    
    if( scoreChulsu > scoreYounghee ){
      System.out.println("철수 승");
    }else if( scoreYounghee > scoreChulsu ){
      System.out.println("영희 승");
    }else {
      System.out.println("무승부");
    }
    
  } //main
} //class
