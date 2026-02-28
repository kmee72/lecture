//연습문제 - 싱글톤 만들기
//클래스 이름 : TossAccount - 싱글톤으로 만들기
//  필드(private) : 계좌번호(1234), 고객이름(홍길동), 잔액(1000), 이자율(년3%)
//  메소드 : 입금(+100), 출금(-100), 이자계산(1년후 잔액), 잔액조회
class TossAccount{
  private static TossAccount singleton;
  private String account = "1234";
  private String name = "홍길동";
  private double balance = 1000;
  private double rate = 0.03;

  public static TossAccount getInstance(){
    if( singleton == null ){
      singleton = new TossAccount();
    }
    return singleton;
  }

  //Getter/Setter 메소드 자동 생성!

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }
  //입금 메소드
  public void income(long money){
    this.balance += money;
  }
  //출금 메소드
  public void outcome(long money){
    this.balance -= money;
  }
  //이자계산 메소드
  public void rebalance(){
    this.balance = this.balance * (1 + this.rate);
  }
  //잔액조회 - getBalance();

} //class

public class ex25 {
  public static void main(String[] args) {
    //0. 싱글톤을 호출후
    TossAccount tossAccount = TossAccount.getInstance();
    //1. 입금 메소드 호출
    tossAccount.income(100);
    //2. 출금 메소드 호출
    tossAccount.outcome(100);
    //3. 이자계산은 이자율을 읽어서 참조한다.
    //   이자계산후 잔액 증가한다.
    tossAccount.rebalance();
    //4. 최종 잔액을 출력한다.
    System.out.println( tossAccount.getBalance() );
  }
}
