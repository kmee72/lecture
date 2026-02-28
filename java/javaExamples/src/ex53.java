//제네릭( Generic )
//    : 자바가 정적타입 언어이기 때문에, 타입 호환성이 엄격하다.
//    : 그러나 형(Type)에 따른 데이터전송을 편하게 하기 위해
//    : 가변적인 타입 선언을 할 수 있도록 했다. (다형성-상속과 관련없음)
//    : JDK 1.5부터 지원.

class Keyboard1 {  //다형성을 이용한 유연한 타입 지원
  //최상위 클래스 Object를 이용하여
  //모든 객체를 담을 수 있다.
  //단점) 다운캐스팅(강제형변환)해야 됨.
  private Object object;

  //getter/setter 자동생성
  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }
}

//T는 타입을 가르키는 심볼.
class Keyboard2<T> { //제네릭을 이용한 유연한 타입 지원
  private T object;

  public T getObject() {
    return object;
  }

  public void setObject(T object) {
    this.object = object;
  }
}

public class ex53 {
  public static void main(String[] args) {
    Keyboard1 k1 = new Keyboard1();
    k1.setObject("키보드1"); //String객체 -> Object (업캐스팅되었다)
    String str1 = (String) k1.getObject(); //Object -> String (다운캐스팅)
    System.out.println(str1);

    Keyboard2<Integer> k2 = new Keyboard2<>(); //객체생성시 타입을 결정한다.
    k2.setObject(10);
    Integer intVal = k2.getObject(); //다운캐스팅을 안해도 됨.
    System.out.println(intVal);

    Keyboard2<String> k3 = new Keyboard2<>(); //객체생성시 타입을 결정한다.
    k3.setObject("문자열");
    String str2 = k3.getObject();
    System.out.println(str2);

    Keyboard2<Student> k4 = new Keyboard2<>();
  }
}
