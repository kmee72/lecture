import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ex59 {
  public static void main(String[] args) {
    //Hash(해시) : 고기를 잘게 다진 요리.
    //   : 데이터의 중복을 피해서 특정위치에 배치하는 알고리즘.
    //   : 예) 도서관의 책에 태그를 붙인다.
    //        13마1234 : 13구간의 마열 1234번째 책.

    //세트(Set) : 중복된 요소를 허용하지 않는 자료구조.
    Set<String> set = new HashSet<>();
    set.add("홍길동");
    set.add("이순신");
    set.add("변사또");
    System.out.println(set);

    //중복을 허용하기 않기에, 같은 데이터를 넣으면 추가 안됨
    boolean isAdded = set.add("홍길동");
    System.out.println(isAdded);
    System.out.println(set);

    //전체 순회
    for (String name : set) {
      System.out.println(name);
    }
    Iterator<String> it = set.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    //집합 연산 - 교집합, 합집합, 차집합
    Set<Integer> setA = new HashSet<>();
    Set<Integer> setB = new HashSet<>();
    setA.add(10);
    setA.add(20);
    setA.add(30);  // [10,20,30]
    setB.add(30);  //        [30,40,50]
    setB.add(40);
    setB.add(50);
    //교집합
    //setA가 교집합으로 변경됨. 원본 상실.
    //setA.retainAll( setB );
    //System.out.println( setA );

    //합집합
    //setA.addAll( setB );
    //System.out.println( "addAll " + setA );

    //차집합
    setA.removeAll( setB );
    System.out.println( "removeAll " + setA );

    //배열,리스트,맵,세트에서 복사할 할때 = 주소값 복사. 주의!
    setA.clear();
    setA.add(10);
    setA.add(20);
    setA.add(30);
    System.out.println( setA );

    Set<Integer> setC = setA; //얇은 복사(주소값만 복사), 주의!
    System.out.println( "setC" + setC );
    setA.remove( 10 );
    System.out.println( "setA" + setA ); //setA [20, 30]
    System.out.println( "setC" + setC );

    Set<Integer> setD = new HashSet<>(setA);//깊은 복사(요소값을 복사)
    System.out.println( setD );
    setD.remove( 20 );
    System.out.println( setD );
    System.out.println( setA );



  }
}
