package by.epam.secondLesson;

/*  Find the second by length string in a list or array
    (Найти вторую по длине строку в списке)*/

/*Issue
1) Добавь метод, который принимает массив и возвращает отсортированный по убыванию длин строк
2) В отсортированном массиве верни второй элемент
3) Предоставь возможность вводить размер массива и заполнять его через консоль
 */

import java.util.Scanner;

public class FindSecondLengthString {
    public static void main(String[] args) {

        int maxLengthPos = 0;
        int middleLengthPos = 0;
        int arraySize = 0;

        String[] words = {"2", "1234", "123",
                "1", "123456", "12345678",
                "123456789", "1234", "1234"};

        String maxLength = words[0];
        String middleLengthStr = words[0];

        for (int i = 0; i < words.length; i++) {
            String tempStr1 = words[i];

            if (tempStr1.length() > maxLength.length()) {

                middleLengthPos = maxLengthPos;
                maxLengthPos = i;

                middleLengthStr = maxLength;
                maxLength = tempStr1;
            }
        }

        System.out.println("Second by length string is " + middleLengthStr);
        System.out.println("Position (in array calculus) " + middleLengthPos);

        Scanner sc = new Scanner(System.in);

        System.out.println("Auto-generate array? (Y/n)");
        String choose = sc.next();

        if (choose.equals("y") || choose.equals("yes") || choose.equals("Yes")) {
            generateStrArrayRandLength(words);
            printStrArray(words);
            sortStrArray(words);
            printStrArray(words);
        } else {
            System.out.println("Enter array size ");
            arraySize = sc.nextInt();
            words = new String[arraySize];
            enterArray(words);
            printStrArray(words);
            sortStrArray(words);
            printStrArray(words);
        }
   }

    private static void enterArray(String[] strArray) {
        for (int i = 0; i<strArray.length; i++){
            System.out.println("Enter " + i + " element ");
            Scanner sc = new Scanner(System.in);
            strArray[i] = sc.next();
        }
    }

    //its !BUBBLE SORT
    protected static void sortStrArray (String[] strArray) {
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
    }

    protected static void printStrArray (String[] strArray) {
        for (int i = 0; i<strArray.length; i++){
            System.out.println(strArray[i]);
        }
        System.out.println();
    }

    protected static int generateStrArrayRandLength(String[] arrayString) {
        int arraySize = (int) (Math.random() * 10);
        arrayString = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arrayString [i] = String.valueOf((int)(Math.random() * 100));
            System.out.print(arrayString [i] + "  ");
        }
        return arraySize;
    }
}