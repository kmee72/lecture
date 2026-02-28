import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ex51 {
  public static void main(String[] args) {
    //ArrayList의 사용 예
    //ArrayList는 가변용량(String동일) - 넣은만큼 들어간다.

    //ArrayList의 다양한 선언 방식
    ArrayList<Integer> nums1 = new ArrayList<Integer>(); //타입명시
    ArrayList<Integer> nums2 = new ArrayList<>(); //타입생략
    //Capacity(용량) : 물리적으로 확보된 메모리 공간
    //리사이징 과정을 생략하므로 성능 향상
    ArrayList<Integer> nums3 = new ArrayList<>(10);
    //다른 arraylist로 초기화하면서 선언
    ArrayList<Integer> nums4 = new ArrayList<>(nums1);
    //데이터를 직접 주면서 선언
    ArrayList<Integer> nums5 = new ArrayList<>(
        Arrays.asList(10, 20, 30, 40, 50)
    );
    System.out.println(nums5);

    //전체 리스트 순회
    //for문
    for (int i = 0; i < nums5.size(); i++) {
      System.out.println(nums5.get(i));
    }
    //향상된 for문
    for (Integer num : nums5) {
      System.out.println(num);
    }
    //이터레이터(Iterator) : 열거자
    //콜렉션의 순차적인 처리를 도와주는 클래스
    //  hasNext() : 다음요소를 가지고 있는지 T/F로 반환
    //  next() : 다음 요소를 반환함.(it카운터++)
    Iterator<Integer> it = nums5.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    //값을 포함하는지 T/F로 반환
    if (nums5.contains(30)) {
      System.out.println("30을 포함함.");
    }
    //특정요소의 인덱스 가져오기
    System.out.println(nums5.indexOf(40));

  }
}
