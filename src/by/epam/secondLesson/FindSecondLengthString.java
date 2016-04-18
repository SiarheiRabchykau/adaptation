package by.epam.secondLesson;

/*  Find the second by length string in a list or array
    (Найти вторую по длине строку в списке)*/

/*Issue
1) Добавь метод, который принимает массив и возвращает отсортированный по убыванию длин строк   - выполнено
2) В отсортированном массиве верни второй элемент                                               - выполнено
3) Предоставь возможность вводить размер массива и заполнять его через консоль                  - выполнено
 */

import java.util.Scanner;

public class FindSecondLengthString {
    private static String[] words;

    public static void main(String[] args) {

        int arraySize;

        Scanner sc = new Scanner(System.in);

        System.out.println("Auto-generate array? (Y/n)");
        String choose = sc.next();

        if (choose.equals("y") || choose.equals("yes") || choose.equals("Yes")) {
            //this is false generate array
            //but this array show work of sort method
            String[] words = {"2", "1234", "123",
                    "1", "123456", "12345678",
                    "123456789", "1234", "1234"};
            printStrArray(words);

            //use one of find of second length element method
            //findSecondLength(words);
            sortStrArray(words);
        } else {
            System.out.println("Enter array size ");
            arraySize = sc.nextInt();
            words = new String[arraySize];
            enterArray(words);
            printStrArray(words);
            sortStrArray(words);
            printStrArray(words);
        }
        sc.close();
   }

    //manual fill array
    private static void enterArray(String[] strArray) {
        for (int i = 0; i<strArray.length; i++){
            System.out.println("Enter " + (i+1) + " element ");
            Scanner sc = new Scanner(System.in);
            strArray[i] = sc.next();
        }
    }

    //its !BUBBLE SORT
    private static void sortStrArray (String[] strArray) {
        for (int i = strArray.length-1; i > 0; i--){
            for(int j = 0; j < i; j++) {
                if (strArray[j].length() < strArray[j+1].length()) {
                    String temp = strArray[j+1];
                    strArray[j+1] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }
        System.out.println("Second element in sort array");
        System.out.println(strArray[1] + "\n");

        printStrArray(strArray);
    }

    //print array
    private static void printStrArray (String[] strArray) {
        for (int i = 0; i<strArray.length; i++){
            System.out.println(strArray[i]);
        }
        System.out.println();
    }

    private static void findSecondLength (String[] strArray) {
        String maxLength = strArray[0];
        String middleLengthStr = strArray[0];
        int maxLengthPos = 0;
        int middleLengthPos = 0;

        for (int i = 0; i < strArray.length; i++) {
            String tempStr1 = strArray[i];

            if (tempStr1.length() > maxLength.length()) {

                middleLengthPos = maxLengthPos;
                maxLengthPos = i;

                middleLengthStr = maxLength;
                maxLength = tempStr1;
            }
        }

        System.out.println("Second by length string is " + middleLengthStr);
        System.out.println("Position (in array calculus) " + middleLengthPos);
    }

    //this method doesn't show as well work of sorting method
/*    //generate array with rand(0-10) length and fill rand number (0-100)
    protected static String[] generateStrArrayRandLength() {
        int arraySize = (int) (Math.random() * 10);
        words = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            words [i] = String.valueOf((int)(Math.random() * 10000));
            System.out.print(words [i] + "  ");
        }
        return words;
    }*/
}