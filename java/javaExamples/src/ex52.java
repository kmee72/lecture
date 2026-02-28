import java.util.ArrayList;
import java.util.Scanner;

class Student {
  String name;
  int kor;
  int eng;
  int math;

  public Student(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }
}

public class ex52 {
  //전역 변수 설정
  public static ArrayList<Student> scoreList =
      new ArrayList<>();

  public static void main(String[] args) {
    //연습문제 - 성적 관리 프로그램
    // ArrayList 클래스 객체 배열을 사용해보자.
    //입력 및 출력 예시
    //-----------성적 관리 프로그램-------------
    //1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 : 1
    //이름 입력 : 홍길동
    //국어점수 입력 : 70
    //영어점수 입력 : 80
    //수학점수 입력 : 90
    Scanner scanner = new Scanner(System.in);
    while (true) {
      printPrompt();
      int menu = scanner.nextInt();
      if (menu == 1) {
        System.out.print("이름 입력:");
        String name = scanner.next();
        System.out.print("국어점수:");
        int kor = scanner.nextInt();
        System.out.print("영어점수:");
        int eng = scanner.nextInt();
        System.out.print("수학점수:");
        int math = scanner.nextInt();
        scoreList.add(new Student(name,kor,eng,math));
      } else if (menu == 2) { //전체출력
        for (Student student : scoreList) {
          //이름: 홍길동 국어: 70 영어: 80 수학: 90 총점: 240 평균: 80.0
          printInfo(student);
          System.out.println();
        }
      } else if (menu == 3) { //검색
        System.out.print("이름 입력:");
        String name = scanner.next();
        for (Student student : scoreList) {
          if( student.name.equals( name )  ) {
            printInfo(student);
          }
        }
      } else if (menu == 4) { //수정
        System.out.print("이름 입력:");
        String name = scanner.next();

        int index = 0;
        for (Student student : scoreList) {
          if( student.name.equals( name )  ) {
            break;
          }
          index ++;
        }

        System.out.print("국어점수:");
        int kor = scanner.nextInt();
        System.out.print("영어점수:");
        int eng = scanner.nextInt();
        System.out.print("수학점수:");
        int math = scanner.nextInt();

        scoreList.set(index, new Student(name,kor,eng,math));

      } else if (menu == 5) { //삭제
        System.out.print("이름 입력:");
        String name = scanner.next();
        int index = 0;
        for (Student student : scoreList) {
          if( student.name.equals( name )  ) {
              scoreList.remove( index );
              break;//바로 탈출한다.
          }
          index++;
        }
      } else if (menu == 6) {
        System.out.println("프로그램 종료!");
        break;
      }

    } //while

    scanner.close();
  } //main

  //-----------성적 관리 프로그램-------------
  //1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 : 2
  //이름: 홍길동 국어: 70 영어: 80 수학: 90 총점: 240 평균: 80.0
  //-----------성적 관리 프로그램-------------
  //1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 : 3
  //이름 입력 :홍길동
  //이름: 홍길동 국어: 70 영어: 80 수학: 90 총점: 240 평균: 80.0
  //-----------성적 관리 프로그램-------------
  //1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 : 4
  //이름 입력 :홍길동
  //국어점수 입력 : 70
  //영어점수 입력 : 80
  //수학점수 입력 : 90
  //-----------성적 관리 프로그램-------------
  //1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 :5
  //이름 입력 :홍길동
  //홍길동 삭제됨.
  //-----------성적 관리 프로그램-------------
  //1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 :6
  //프로그램이 종료되었습니다.

  static void printInfo(Student s) {
    System.out.print("이름: " + s.name);
    System.out.print(" 국어: " + s.kor);
    System.out.print(" 영어: " + s.eng);
    System.out.print(" 수학: " + s.math);
    int sum = s.kor + s.eng + s.math;
    double avr = Math.round(sum / 3.0);
    System.out.print(" 총점:" + sum);
    System.out.print(" 평균:" + avr);
  }

  static void printPrompt() {
    System.out.println();
    System.out.println("-----------성적 관리 프로그램-------------");
    System.out.print("1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 :");
  }
} //class
