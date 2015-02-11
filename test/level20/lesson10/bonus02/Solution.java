package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {1, 0, 1, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
       int count = 0;
        int ITopLeft = 0;
        int JTopLeft = 0;
        int JTopRight = 0;
        int ILowRight = 0;
        boolean TopLeftFound = false;
        boolean TopRightFound = false;
        boolean LowRightFound = false;
      //int maxRows = a[i].length;


        for (int i = 0; i < a.length;i++) {
           for (int j = 0; j < a[i].length; j++) {
               //find top left point
               if (!TopLeftFound) {
                    if (a[i][j] == 1){
                        ITopLeft = i;
                        JTopLeft = j;
                        TopLeftFound = true;
                    }
               }
               //find top right point
               if (TopLeftFound && !TopRightFound){
                   int k  = JTopLeft;
                   while (  k < a[j].length && (a[ITopLeft][k] != 0 )) {
                       if (a[ITopLeft][k] == 1) {
                       JTopRight = k;}
                       else if (a[ITopLeft][k] == 0)
                           break;
                       k++;
                   }
                   TopRightFound = true;

               }
               if (TopLeftFound && TopRightFound && !LowRightFound){
                   int m = ITopLeft;
                   while (m < a.length )  {
                       if (a[m][JTopRight] == 1)
                       {ILowRight = m;}
                       else if (a[m][JTopRight] == 0)
                       break;
                       m++;
                   }
                   LowRightFound = true;
               }


               if (TopLeftFound && TopRightFound && LowRightFound) {
                   System.out.println("Top left : ["+ ITopLeft+","+ JTopLeft+"]  Low right : [" + ILowRight+"," + JTopRight +"]");
                   for (int r = ITopLeft; r <=ILowRight ; r++) {
                       for (int t = JTopLeft; t <= JTopRight ; t++) {
                           a[r][t] = 0;

                       }
                  }
                 count++;
                   TopLeftFound = false;
                   TopRightFound = false;
                   LowRightFound = false;
                   i = 0;
                   j = 0;

               }


           }
        }


        return count;
    }
}
