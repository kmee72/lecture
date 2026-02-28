import java.io.BufferedReader;
import java.io.FileReader;

public class ex47 {
  public static void main(String[] args) {
    //연습문제
    //철수는 초등학교 교사이다.
    //학생 영희, 수만, 순신의 성적관리 프로그램을 작성하고자 한다.
    //score.txt에 저장하고, 읽어 오는 프로그램을 작성해 보자.
    //파일 형식
    //이름 영어 수학 국어\n
    //영희 100 80 70\n
    //수만 80 80 70\n
    //순신 90 80 70\n
    //그다음 학생이름과 과목을 Scanner로 입력받고,
    //점수를 출력하는 프로그램을 작성하시오.
    //입력예) 영희 영어
    //출력예) 100

    //FileReader : 바이트 단위로 읽어오기
    //BufferedReader : \n문자까지 한줄 읽어오기
    try {
      FileReader fr = new FileReader("score.txt");
      BufferedReader br = new BufferedReader(fr);
      String line;

      while ((line = br.readLine()) != null){ //null은 마지막줄.
        System.out.println(line);
      }
      br.close();
    }
    catch (Exception e){
      e.printStackTrace();
    }
    // Exception 자주 발생하는 곳
    // 1. 파일 처리할 때
    // 2. 통신
    // 3. 형변환(10진수 -> 2진수)


  }
}
