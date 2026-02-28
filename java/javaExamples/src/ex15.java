import java.util.Arrays;
import java.util.Collections;

public class ex15 {
  public static void main(String[] args) {
    //ES6
    //  배열 + 리스트 하나로 통합되어 있다.
    //  배열 : 데이터가 순차적으로 놓여있는 자료구조
    //  리스트 : 배열 + 중간에 추가/삭제가 가능
    //자바
    //  배열과 리스트가 분리되어 있다.

    //정수형 1차 배열
    //1.
    int[] arrNums1 = {10, 20, 30};
    //let arrNums1 = [10,20,30];
    System.out.println(arrNums1[0]);
    System.out.println(arrNums1[1]);
    System.out.println(arrNums1[2]);
    //2.
    int arrNums2[] = {10, 20, 30}; //비추천
    System.out.println(arrNums2[0]);
    //3.
    int[] arrNums3 = new int[3]; //길이 3인 배열생성
    //0으로 초기화되어 있다.
    System.out.println(arrNums3[0]);
    //4.
    int[] arrNums4 = new int[]{10, 20, 30};
    System.out.println(arrNums4[0]);

    //안되는 경우
    //int[] a;
    //a = {3,4,5};

    //배열의 순환
    for (int i = 0; i < arrNums1.length; i++) {
      System.out.println(arrNums1[i]);
    }
    //향상된 for문, for-each문 (JS for-of문 )
    for (int num : arrNums1) {
      System.out.println(num);
    }

    //배열의 정렬(sort)
    int[] nums = {10, 30, 20, 50, 40};
    //import java.util.Arrays;
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));

    //내림차순 정렬
    Integer[] nums2 = {10, 30, 20, 50, 40};
    Arrays.sort( nums2, Collections.reverseOrder() );
    System.out.println(Arrays.toString(nums2));

    //Integer는 정수형 래퍼(Wrapper) 클래스이다.
    //클래스로서 int(기본형)에 없는 기능을 확장한 클래스(객체)이다.
    //int(원시타입)를 클래스로 만든 것이다.

    //자바 자체를 클래스 지원 언어(OOP)이다.
    //int(원시형)이 클래스로 만들면, 다형성을 이용한 데이터 이동이 편리하다.

  }
}
