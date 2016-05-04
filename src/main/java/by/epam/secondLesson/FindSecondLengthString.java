package main.java.by.epam.secondLesson;

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
            words = new String[]{"v", "123456", "qwerty", "testing", "wat", "soft", "rare"};
        } else {
            System.out.println("Enter array size ");
            arraySize = sc.nextInt();
            words = new String[arraySize];
            //manual fill array
            enterArray(words);
        }

        //print array with replaces symbols
        printStrArray(words);

        //Сhange by places first and last letters in each second string
        replaceSymbols(words);

        printStrArray(words);

        //sort array and print second element
        sortStrArray(words);
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

        printStrArray(strArray);
    }

    //print array
    private static void printStrArray (String[] strArray) {
        for (int i = 0; i<strArray.length; i++){
            System.out.println(strArray[i]);
        }
        System.out.println();
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
}