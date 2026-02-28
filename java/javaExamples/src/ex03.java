public class ex03 {
  public static void main(String[] args) {
    //데이터 타입(Data Type)
    //숫자 타입(JS number)
    //  정수형 : int(4) long(8) short(2) byte(1)
    //  실수형 : float(4) double(8)
    //문자 타입(JS string)
    //  char(2)
    //문자열 타입(JS string)
    //  String : 가변길이
    //부울 타일(JS boolean)
    //  boolean(1)

    //JS 동적 타입 언어 : 변수(리터럴)에 대입시 결정
    // let a = 10; number타입
    //Java 정적 타입 언어 : code에서 타입을 결정
    int myInt = 10;
    // soutv
    System.out.println("myInt = " + myInt);
    long myLong = 20L; // L은 Long을 의미. 8바이트 Long으로 초기화한다.
    System.out.println("myLong = " + myLong);
    //              4byte int로 임시변경후 short로 형변환.
    short myShort = 32767;
    System.out.println("myShort = " + myShort);
    byte myByte = 127;
    System.out.println("myByte = " + myByte);

    //실수형
    float myFloat = 3.14f; //f를 리터럴에 넣어야 됨
    System.out.println("myFloat = " + myFloat);
    double myDouble = 6.14; //double로 초기화됨.
    System.out.println("myDouble = " + myDouble);

    //논리형(부울형)
    boolean myBool = true;
    System.out.println("myBool = " + myBool);

    //문자형
    char myChar = '가'; // 단따옴표만 가능
    System.out.println("myChar = " + myChar);
    // 유니코드표에서 '가'의 44032, 0xAC00
    System.out.println("(int)myChar = " + (int) myChar);
    System.out.println("(char)0xAC00 = " + (char) 0xAC00);
    // 유니코드표의 첫장은 아스키코드표이다.
    System.out.println((char) 65); //A
    System.out.println((int) 'A'); //65

    //문자열
    String myString = "가나다";
    System.out.println("myString = " + myString);

    //코드 재정렬(JS : Prettier Formatter)
    //CTRL + ALT + L
  }
}
