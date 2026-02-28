//생성자 함수(Constructor)
//   : 클래스가 생성될 때(new) 자동으로 호출되는 메소드
//   : 메소드 이름은 클래스와 동일하고
//   : 용도 - 필드(멤버변수)를 초기화할 때
class Book {
  int price = 1000;//속성
  //생성자함수 패턴
  //public 반환타입x 클래스이름() { }
  public Book( int price ){
    this.price = price;
    System.out.println( this.price );
    System.out.println("생성자함수 자동호출됨.");
  }
  void read(){//행동
    System.out.println("읽는다.");
  }
}

public class ex26 {
  public static void main(String[] args) {
    Book book = new Book( 2000 );
    System.out.println( book.price );
  }
}
