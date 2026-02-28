import java.util.Arrays;

public class ex05 {
  public static void main(String[] args) {
    //문자열 관련 함수들
    String str1 = "Hello Java!";
    String str2 = "안녕하세요! 반갑습니다.";
    //문자열 길이
    System.out.println(str1.length());
    System.out.println(str2.length());
    //문자 하나 가져오기
    char c1 = str1.charAt( 0 ); //0은 맨 첫문자 의미
    System.out.println("c1 = " + c1);
    char c2 = str1.charAt( 1 );
    System.out.println("c2 = " + c2);
    //문자열의 위치(인덱스) 가져오기
    //"Hello Java!"
    System.out.println(str1.indexOf("Java"));
    //마지막 문자열의 위치 가져오기
    System.out.println(str1.lastIndexOf("a"));

    String str3 = "Java Study";
    //대문자
    System.out.println(str3.toUpperCase());
    //소문자
    System.out.println(str3.toLowerCase());
    //문자열 검색시 소문자로 바꿔서 검색한다.
    System.out.println(str3.toLowerCase().indexOf("java"));
    //문자열 치환하기
    System.out.println(str3.replace("Study", "공부"));
    //문자열 일부 가져오기  "Java Study"
    System.out.println(str3.substring(0, 4)); //시작인덱스 끝인덱스(+1)
    //문자열을 분리해서 문자열 배열로 가져오기
    String[] strArray = "abc/def-ghi jkl".split("/|-| ");
    System.out.println("strArray = " + strArray);
    System.out.println("strArray = " + Arrays.toString(strArray));
    //양쪽 공백제거
    System.out.println(" abc ".trim());
    System.out.println(" abc def ".trim());
    //모든 공백제거
    System.out.println(" abc def ".replaceAll(" ", ""));
    //문자열 연결함수
    System.out.println("abc".concat("123"));
    //문자열을 포함하는지 true/false로 반환하는 함수
    System.out.println("abc123".contains("123"));

    //문자열 비교할 때 Java만의 특징
    String str4 = "Java";
    String str5 = "java";
    // 주소값을 가진 정수를 비교하므로 안됨.
    System.out.println( str4 == str5 );
    // 내용 비교
    System.out.println( str4.equals( str5 ) );
    // 대부분의 언어들이 문자열을 비교할 때 ==를 쓴다.
    // JS, C#, Python 등에서

    String str6 = "abc";
    String str7 = new String("abc");
    System.out.println( str6 == str7 );
    System.out.println( str6.equals(str7) );
  }
}
