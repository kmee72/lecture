public class ex41 {
  public static void main(String[] args) {
    //String 관련 클래스
    //StringBuffer : 문자열을 좀더 유연하게 제어할 수 있다.
    //             : 추가(append), 삽입(insert), 삭제(delete) 함수
    //StringBuilder : 기능이 동일. 대량의 문자열을 처리할 때 속도향상.

    //StringBuffer      StringBuilder
    //멀티스레드        단일스레드(속도향상)
    //데이터 동기화지원 미지원

    StringBuffer sb = new StringBuffer("abc");
    System.out.println(sb);

    sb.append("def");
    System.out.println(sb);

    sb.insert( 3, "123");
    System.out.println(sb);

    sb.delete(2, 4); //시작과 끝 인덱스
    System.out.println(sb);

    StringBuilder builder = new StringBuilder( sb );
    builder.append("def");
    builder.insert(3, "ijk");
    builder.delete(2, 4);

  }
}
