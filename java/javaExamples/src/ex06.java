public class ex06 {
  public static void main(String[] args) {
    //연산자의 종류
    //단항 : ++ -- !(논리반전) (타입)   우선순위 제일 높다.
    //산술 : + - * / %
    //비교 : < > <= >= == != instanceof(객체비교연산자)
    //논리 : && ||
    //삼항 : ?연산자
    //대입 : = 복합대입(+= -= *= /= %= ...)  우선순위가 제일 낮다.
    
    //단항연산자
    int i = 10;
    i++;
    System.out.println("i = " + i);
    i--;
    System.out.println("i = " + i);

    //논리반전
    System.out.println( !true );
    System.out.println( !false );

    //형변환
    int j = 20;
    short s = (short)j;
    System.out.println( s );
  }
}
