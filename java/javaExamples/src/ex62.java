import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ex62 {
  public static void main(String[] args) {
    //stream 계열의 함수들
    //  : 알고리즘(코테)시에 복잡하지만 강력한 기능.
    //  : JS 배열.map() reduce() filter()

    //filter(조건 필터링)
    List<Integer> nums = Arrays.asList(1, 15, 8, 20, 5, 30);
    //10보단 큰 숫자만 리스트로 다시 만들기
    List<Integer> result = nums.stream()
        //.filter( (n) -> {return n>10; } )
        .filter(n -> n > 10)
        .collect(Collectors.toList());
    System.out.println(result);

    //map (데이터 변형)
    List<String> words = Arrays.asList("apple", "banana", "cherry");
    //단어를 대문자로 변환하기
    List<String> upperWords = words.stream()
        .map(String::toUpperCase)
        .collect(Collectors.toList());
    System.out.println(upperWords);

    //reduce (결과를 하나의 값으로 응축)
    List<Integer> vals = Arrays.asList(1, 2, 3, 4, 5);
    //모든 숫자의 합 구하기
    int sum = vals.stream().reduce(0, //acc의 초기값
        (acc, cur) -> acc + cur);
    System.out.println(sum);

    //sort 정렬
    List<String> names = Arrays.asList("이순신", "강감찬", "을지문덕");
    //가나다순 정렬
    List<String> sorted = names.stream()
        .sorted()
        .collect(Collectors.toList());

    // limit 개수 제한
    List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> firstThree = nums2.stream()
        .limit(3)
        .collect(Collectors.toList());
    System.out.println( firstThree );

    //anyMatch  : 조건에 만족하는 요소가 하나라도 있으면 true를 반환함.
    List<String> tech = Arrays.asList("Java", "Spring", "Python");
    boolean hasPython = tech.stream()
        .anyMatch(  s -> s.equals("Python") );
    System.out.println( hasPython );

    //collect(groupingBy) (그룹화)
    List<String> items = Arrays.asList("Apple", "Ant", "Banana", "Box", "Car");
    //첫글자를 기준으로 그룹 묶기
    Map<Character, List<String>> groupedByFirstChar = items.stream()
        .collect( Collectors.groupingBy( s -> s.charAt(0) ) );
    System.out.println( groupedByFirstChar );
    //map : {A=[Apple, Ant], B=[Banana, Box], C=[Car]}
    System.out.println( groupedByFirstChar.get('A'));
    System.out.println( groupedByFirstChar.get('B'));
    System.out.println( groupedByFirstChar.get('C'));

  }
}
