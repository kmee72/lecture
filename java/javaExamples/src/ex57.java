import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ex57 {
  public static void main(String[] args) {
    //스택과 큐
    //스택(Stack) : FILO(First Input Last Out)
    //            : 맨 나중에 들어간 요소가 먼저 나오는 자료구조
    //            : 용도 ) 함수 호출시 이전 함수의 주소,데이터를 보관
    //큐(Queue) : FIFO(First Input First Out)
    //          : 맨 처음 들어가 요소가 맨 처음에 나온다.
    //          : 용도 ) 버퍼(Buffer)
    //             입력속도와 출력속도가 다른 경우 완충역할을 한다.
    Stack<Integer> stack = new Stack<>();
    stack.push( 10 );  //마지막에 추가
    System.out.println( stack );
    stack.push( 20 );
    System.out.println( stack );
    stack.push( 30 );
    System.out.println( stack );
    //맨 마지막 요소를 반환하면서 지움.
    System.out.println( stack.pop() );
    System.out.println( stack );

    //최상단(마지막)요소를 반환, 지우지는 않는다.
    System.out.println( stack.peek() );
    System.out.println( stack );
    System.out.println( stack.size() );
    System.out.println( stack.contains( 20 ) );
    System.out.println( stack.empty() );

    //LinkedList가 Queue를 상속 받았으므로 업캐스팅되었다.
    Queue<Integer> queue = new LinkedList<>();
    queue.add( 10 );
    System.out.println( queue );
    queue.add( 20 );
    System.out.println( queue );
    queue.add( 30 );
    System.out.println( queue );

    queue.offer( 40 );  //맨 뒤에 추가
    System.out.println( queue );

    //LinkedList는 가변용량이라서 용량제한이 거의 없음.
    //add : 실패시 Exception 발생(반드시 추가될 것으로 알고 설계)
    //offer : 실패시 false 반환(실패를 가정하고 설계)

    //제일 먼저 들어간 값을 제거, 그 값을 반환
    System.out.println( queue.poll() );
    System.out.println( queue );
    //제일 먼저 들어간 값을 반환, 제거안함
    System.out.println( queue.peek() );
    System.out.println( queue );
    System.out.println( queue.size() );

  }
}
