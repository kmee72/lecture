import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class ex55 {
  public static void main(String[] args) {
    //LocalDate, LocalTime, LocalDateTime
    //JDK 1.8부터 지원.
    //타임존 개념이 없는 단순 날짜/시간 정보 출력
    //오픈소스인 JodaTime 클래스를 본따서 만듦.
    //최신 트렌드는 Date보다는 Local계열을 사용한다.

    //Date,Calender의 단점
    //1. get/set함수로 인해서 값이 중간에 변경될 수 있다.
    //2. 1월을 0으로 표현하는 문제
    //3. 년/월/일 계산은 Date로만 안되고 Calendar를 사용해야 됨.

    //LocalDate
    LocalDate now = LocalDate.now();
    System.out.println("now = " + now);
    //날짜 설정
    LocalDate birthDay = LocalDate.of(2000, 12, 1);
    System.out.println("birthDay = " + birthDay);
    //문자열로 날짜 설정(yyyy-MM-dd)
    LocalDate xmax = LocalDate.parse("2026-12-25");
    System.out.println("xmax = " + xmax);
    // 2026/12/25  2026.12.25 2026 12 25  20261225 2026:12:25
    System.out.println(xmax.plusDays(5));

    //LocalTime
    LocalTime nowTime = LocalTime.now();
    System.out.println("nowTime = " + nowTime);
    //17:45:22.464594600
    //세계시간-프랑스파리(한국 Asia/Seoul)
    LocalTime parisTime = LocalTime.now(ZoneId.of("Europe/Paris"));
    System.out.println("parisTime = " + parisTime);
    //시간 설정
    LocalTime sleepTime = LocalTime.of(23, 30, 0);
    System.out.println(sleepTime);
    //시간 더하기/빼기
    LocalTime getupTime = sleepTime.plusHours(8);
    System.out.println(getupTime);
    LocalTime inHouseTime = sleepTime.minusHours(5);
    System.out.println(inHouseTime);

  }
}
