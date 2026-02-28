//클래스(객체) 타입의 배열 제어하기
class Snack {
  String name = "새우깡";
  int price = 1000;

  public Snack(String name, int price) {
    this.name = name;
    this.price = price;
  }
}

public class ex33 {
  public static void main(String[] args) {
    //정수형 1차 배열
    int[] nums = new int[5]; //0으로 초기화됨.
    System.out.println(nums[0]);
    //클래스형 1차 배열 : 클래스도 하나의 타입으로 생각한다.
    Snack[] snacks = new Snack[5]; //null로 초기화됨.
    System.out.println(snacks[0]);
    snacks[0] = new Snack("짱구", 2000);
    snacks[1] = new Snack("포카칩", 3000);
    snacks[2] = new Snack("허니버터칩", 4000);
    snacks[3] = new Snack("프링글스", 5000);
    snacks[4] = new Snack("엄마손쿠키", 6000);

    //순회
    for( Snack snack : snacks ){
      System.out.println(snack.name);
      System.out.println(snack.price);
    }


  }
}
