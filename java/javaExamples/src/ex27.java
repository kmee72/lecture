//연습문제
//클래스이름 : Desk2
//속성 - 필드(멤버변수) : color = "갈색"
//행동 - 메소드(함수) : work() "일한다"로 출력
//     - 생성자 함수에 color값을 "흰색" 초기화 하여,
//       객체생성하시오.
class Desk2 {
  String color = "갈색";

  //생성자함수 자동생성
  public Desk2(String color) {
    this.color = color;
  }

  //Getter/Setter 자동생성
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  void work(){
    System.out.println("일한다.");
  }
}

public class ex27 {
  public static void main(String[] args) {
    Desk2 desk2 = new Desk2("흰색");
    System.out.println( desk2.color );
  }
}
