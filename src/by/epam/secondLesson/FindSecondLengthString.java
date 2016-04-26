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

1) Предоставь возможность вводить размер массива и заполнять его через консоль  - выполнено
2) В задании написано, что в каждой второй строке списка нужно
    менять местами буквы. То есть, во второй, четвёртой и т.д.                  - выполнено
3) Меняй местами буквы в отдельном методе.                                      - выполнено
 */

/*Second issue
1) (choose.equals("y") || choose.equals("yes") || choose.equals("Yes")) Это можно сократить
                                                                                - сокращено регулярным выражением

2) Есть большой кусок кода, который у тебя дублируется в этом классе. Дублирование кода нужно убрать.
                                                    - если я правильно понял, то дублирование было в повторении четырёх
                                                    - методов для манипуляции с массиом : print, replace, print, sort
                                                    - я эти методы вынес в отдельный метод http://bit.ly/1XUiqi0

3) Убери лишний код и лишние классы)                - Удалён класс ReplaceSymbols, удалены старые методы
*/

import java.util.Scanner;

public class FindSecondLengthString {
    private static String[] words;

    public static void main(String[] args) {

        int arraySize;

        Scanner sc = new Scanner(System.in);

        System.out.println("Auto-generate array? (Y/n)");
        String choose = sc.next();

        //add regex
        if (choose.matches("y|[Yy]es")) {

            generateStrArrayRandLength();

            printReplacePrintSortBlock(words);

        } else {
            System.out.println("Enter array size ");
            arraySize = sc.nextInt();
            words = new String[arraySize];

            //manual fill array
            enterArray(words);

            printReplacePrintSortBlock(words);
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
        System.out.printf("Second element %s in sort array: " + "\n", strArray[1]);
       // System.out.println(strArray[1] + "\n");

        printStrArray(strArray);
    }

    //print array
    private static void printStrArray (String[] strArray) {
        for (int i = 0; i<strArray.length; i++){
            System.out.println(strArray[i]);
        }
        System.out.println();
    }

    //this method doesn't show as well work of sorting method
    //generate array with rand(0-10) length and fill rand number (0-100)
    private static void generateStrArrayRandLength() {
        int arraySize = (int) (Math.random() * 10);
        words = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            words [i] = String.valueOf((int)(Math.random() * 10000));
        }
    }

    //Сhange by places first and last letters in each second string
    private static void replaceSymbols (String[] strArray) {
        System.out.println("replaceSymbols method work");
        for (int i = 0; i < strArray.length; i++) {
            if (!(i % 2 == 0)) {
                char charWord[] = strArray[i].toCharArray();
                int charLength  = charWord.length - 1;
                char temp       = charWord[0];

                charWord[0] = charWord[charLength];
                charWord[charLength] = temp;

                strArray[i] = new String (charWord);
            }
        }
    }

    private static void printReplacePrintSortBlock(String[] strArray){
        //print filled array
        printStrArray(strArray);

        //Сhange by places first and last letters in each second string
        replaceSymbols(strArray);

        //print array with replaces symbols
        printStrArray(strArray);

        //sort array and print second element
        sortStrArray(strArray);
    }
}