public class ex13 {
  public static void main(String[] args) {
    //이중반복문
    //일차반복문 : 1차배열 접근
    //이중반복문 : 2차배열 접근
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.println(i + "," + j);
      }
    }
    //정수형 2차배열
    int[][] nums2D = {{1, 2}, {3, 4}};
    //전체 순회
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.println(nums2D[i][j]);
      }
    }

    //별찍기
    //*****
    //*****
    //*****
    //*****
    //*****
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print("*"); //줄바꿈없이 별찍기
      }
      System.out.println(); //줄바꿈
    }
    //연습문제
    //1
    //출력 예) i
    //    *    0  공백4 별1
    //   **    1  공백3 별2
    //  ***    2  공백2 별3
    // ****    3  공백1 별4
    //*****    4  공백0 별5
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5 - 1 - i; j++) {
        System.out.print(" "); //공백찍기
      }
      for (int j = 0; j < i + 1; j++) {
        System.out.print("*"); //별찍기
      }
      System.out.println(); //줄바꿈
    }
    //2
    //출력 예)
    //*******
    //*    **
    //*   * *
    //*  *  *
    //* *   *
    //**    *
    //*******
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (i == 0 || i == 6) {
          System.out.print("*"); //별찍기
        } else if (j == 0 || j == 6) {
          System.out.print("*");
        } else if (7 - 1 - i == j) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println(); //줄바꿈
    }
  }
}
