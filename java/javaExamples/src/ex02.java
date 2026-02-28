public class ex02 {
    public static void main(String[] args) {
        //출력문
        System.out.println("화면출력");
        System.out.println("화면"+"출력");
        System.out.println("10"+20);
        System.out.println(10+"20");
        System.out.println(10+20);

        //println  print  printf
        System.out.println("한줄출력후 줄바꿈");
        System.out.print("한줄출력후 줄바꿈없음");
        System.out.print("연결되어 보인다.");
        //형식화된 출력문(formatted print)
        System.out.println(); //한줄바꿈 용도
        System.out.printf("%d\n", 30); //decimal 10진 정수
        System.out.printf("%o\n", 30); //octal 8진 정수
        System.out.printf("%x\n", 30); //hexa 16진 정수
        System.out.printf("%e\n", 300.0); //exponent 지수형 표현
        // \n은 줄바꿈해주는 특수문자이다.
        //자릿수 맞추기
        System.out.printf("%5d\n", 123); // 5자릿수(공백으로 맞춤)
        System.out.printf("%05d\n", 123); // 5자릿수(0으로 맞춤)
        // f : float,double 실수라는 의미. f를 생략하면 double이다.
        System.out.printf("%05.2f\n", 123.45); // 소숫점 두째자리

    }
}
