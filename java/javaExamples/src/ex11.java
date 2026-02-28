public class ex11 {
  public static void main(String[] args) {
    //switch문
    //java 1.8(8버전) -> 11,17,21,25버전
    //개발환경의 JDK버전과 배포환경의 JDK버전 일치해야.
    //윈도우(맥)           리눅스(21->8)
    //Java 8에서 괄호()안에 들어갈 수 있는 타입
    //정수형 : byte,short,char,int
    //문자열 : String
    //열거형(enum) : enum
    //불가 : boolean, long, float, double
    int score = 90;
    switch (score) {
      case 90:
        System.out.println("90");
        //break; 생략하면 fall through
      case 80:
        System.out.println("80");
        break;
      default:
        System.out.println("그외의 수");
        break;
    }

    String fruit = "사과";
    switch (fruit){
      case "딸기":
        System.out.println("딸기");
        break;
      case "사과":
        System.out.println("사과");
        break;
    }

    int month = 3;
    switch (month){
      case 3,4,5: //java 14부터 가능
        System.out.println("봄");
    }
    //도커(컨테이너)기반(MSA, 클라우드)의 배포에서는
    // app + 개발환경을 하나의 패키지로 배포하므로
    // 배포환경의 영향을 거의 받지 않는다.

    //클라우드 : 구름, 누구나 서버에 접속해서
    // 동일한 환경으로 서비스를 이용한 것.
    // 배포 및 서비스도 클라우드를 이용한다. AWS, GCP.

  }
}
