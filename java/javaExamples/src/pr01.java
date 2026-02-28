import java.util.Scanner;

public class pr01 {
    public static void main(String[] args) {
        //문제 1
        System.out.println("Hello");

        //문제 7
        Scanner scan = new Scanner(System.in);
        System.out.println("숫자입력:");
        int i = scan.nextInt();
        System.out.println("i = " + i);

        System.out.println("문자열입력:");
        String str = scan.next();
        System.out.println("str = " + str);
    }
}
