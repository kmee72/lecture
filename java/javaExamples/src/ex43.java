public class ex43 {
  public static void main(String[] args) {
    //예외 처리(Exception Handing)
    //  : 예외 - 에러(Error), 예상치못한 오류
    //  : 실행시(Runtime)에 처리 가능한 문법을 만듦

    //1. try catch문, try catch finally문
    //2. throws문

    // 패턴
    // try {
    //    예외가 발생할 만한 실행문.
    // }
    // catch( 예외클래스 객체 ) {
    //     예외발생시 처리하는 실행문( 에러내용 출력 )
    // }
    // finally {
    //     예외가 발생하든지 안하든지 무조건 수행.
    //     수행하던 코드(자원-메모리)를 정리하는 코드.
    // }

    // null Exception(널 처리 오류)
    String name = null;
    System.out.println( name );

    try {
      // NullPointerException
      // Cannot invoke "String.toLowerCase()" because "name" is null
      System.out.println(name.toLowerCase());
    }
    catch (Exception e) {
      System.out.println( e.getMessage() ); //예외 메시지 출력
      e.printStackTrace(); //예외 발생 경로 출력
    }

    try {
      //배열 인덱싱 예외
      int[] nums = { 10, 20, 30 };
      //ArrayIndexOutOfBoundsException
      System.out.println( nums[3] );

      //0으로 나누기
      //ArithmeticException
      System.out.println( 10 / 0 );
    }
    catch (ArrayIndexOutOfBoundsException e){
      System.out.println("ArrayIndexOutOfBoundsException");
      //System.out.println(e.getMessage());
    }
    catch (ArithmeticException e){
      System.out.println("ArithmeticException");
      //System.out.println(e.getMessage());
    }
    //모든 Exception은 Exception클래스을 상속받는다.
    catch (Exception e) {
      System.out.println("Exception");
      //System.out.println(e.getMessage());
      //e.printStackTrace();
    }
    finally {
      System.out.println("정리하는 코드");
      //예) scan.close();
    }

    System.out.println("I am Live still~");

  }
}




