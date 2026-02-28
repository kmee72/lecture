//연습문제 - 클래스 설계 - 게시판에 스샷을 첨부하세요.
// 1.
// 카페를 클래스로 설계해보자
// 클래스이름 : Cafe
// 속성 : coffeeCount   커피갯수는 10개로 초기화
// 행동 : sale          출력값은 "커피를 판다"
//클래스를 설계하고, 객체를 생성해서 속성값을 출력하고,
//  행동을 실행시켜보자.
// sale함수를 호출하면 coffeeCount가 하나 준다.
// sale함수를 3번 호출후, coffeeCount를 출력하시오.
class Cafe {
  int coffeeCount = 10;
  void sale(){
    coffeeCount--;
    System.out.println("커피를 판다");
  }
}
//2.
// 당근농장을 클래스로 설계해 보자
// 클래스이름 : Farm
// 속성 : carrot 당근의 갯수 초기값은 0
// 행동 : plant() 호출시마다 당근을 하나씩 생산하고,
//       속성 carrot++를 해준다.
//       호출시 "당근을 1개 생산했습니다." 출력한다.
// 당근을 plant()함수를 이용하여 5개 생산한 후 당근 갯수를
// 출력하시오.
class Farm {
  int carrot = 0;
  void plant(){
    carrot++;
    System.out.println("당근을 1개 생산했습니다.");
  }
}
public class ex19 {
  public static void main(String[] args) {
    Cafe myCafe = new Cafe();
    System.out.println(myCafe.coffeeCount);
    myCafe.sale();
    myCafe.sale();
    myCafe.sale();
    System.out.println(myCafe.coffeeCount);

    Farm myFarm = new Farm();
    myFarm.plant();
    myFarm.plant();
    myFarm.plant();
    myFarm.plant();
    myFarm.plant();
    System.out.println(myFarm.carrot);
  }
}
