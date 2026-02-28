public class ex14 {
  public static void main(String[] args) {
    //while do-while문

    //while문 패턴
    //초기화문;
    //while(조건식(절)){
    //   실행문;
    //   증감문;
    //}
    int i=0;
    while(i<5){
      System.out.println("i = " + i);
      i++;
    }

    // 적어도 한번은 수행후에 조건비교한다.
    int j=0;
    do {
      System.out.println("j = " + j);
      j++;
    }while(j<5);

  }
}
