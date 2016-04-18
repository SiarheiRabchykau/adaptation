package by.epam.secondLesson;

/*  Find the second by length string in a list or array
    (Найти вторую по длине строку в списке)*/

/*Issue
1) Добавь метод, который принимает массив и возвращает отсортированный по убыванию длин строк   - выполнено
2) В отсортированном массиве верни второй элемент                                               - выполнено
3) Предоставь возможность вводить размер массива и заполнять его через консоль                  - выполнено

Я объеденил данный класс с ReplaceSymbols. Это ни на что не повлияет, но мне меньше писать)
Сhange by places first and last letters in each second string of list or array
    (Поменять местами первую и последнюю буквы в каждой второй строке списка).

1) Предоставь возможность вводить размер массива и заполнять его через консоль  -
2) В задании написано, что в каждой второй строке списка нужно                  -
    менять местами буквы. То есть, во второй, четвёртой и т.д.                  - В каждой второй и меняет (бага небыло)
3) Меняй местами буквы в отдельном методе.                                      -
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
            //generateStrArrayRandLength();
            String[] words = {"v", "123456", "qwerty", "testing", "wat", "soft", "rare"};

            //print generated array
            printStrArray(words);

            //use one of find of second length element method
            //findSecondLength(words);

            //Сhange by places first and last letters in each second string
            replaceSymbols(words);

            //print array with replaces symbols
            printStrArray(words);

            //sort array and print second element
            sortStrArray(words);
        } else {
            System.out.println("Enter array size ");
            arraySize = sc.nextInt();
            words = new String[arraySize];

            //manual fill array
            enterArray(words);

            //print filled array
            printStrArray(words);

            //Сhange by places first and last letters in each second string
            replaceSymbols(words);

            //print array with replaces symbols
            printStrArray(words);

            //sort array and print second element
            sortStrArray(words);
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
    //generate array with rand(0-10) length and fill rand number (0-100)
    private static void generateStrArrayRandLength() {
        int arraySize = (int) (Math.random() * 10);
        words = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            words [i] = String.valueOf((int)(Math.random() * 10000));
            System.out.print(words [i] + "  ");
        }
    }

    //Сhange by places first and last letters in each second string
    private static void replaceSymbols (String[] strArray) {
        System.out.println("replaceSymbols method work");
        for (int i = 0; i < strArray.length; i++) {
            if (i % 2 == 0) {
                char charWord[] = strArray[i].toCharArray();
                int charLength  = charWord.length - 1;
                char temp       = charWord[0];

                charWord[0] = charWord[charLength];
                charWord[charLength] = temp;

                strArray[i] = new String (charWord);
            }
        }
    }
}