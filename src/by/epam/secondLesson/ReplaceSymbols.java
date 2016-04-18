package by.epam.secondLesson;

 /* Сhange by places first and last letters in each second string of list or array
    (Поменять местами первую и последнюю буквы в каждой второй строке списка).*/

/*Issue
1) Предоставь возможность вводить размер массива и заполнять его через консоль
2) В задании написано, что в каждой второй строке списка нужно                  -
    менять местами буквы. То есть, во второй, четвёртой и т.д.                  - В каждой второй и меняет (бага небыло)
3) Меняй местами буквы в отдельном методе.                                      -
 */
public class ReplaceSymbols {
    public static void main(String[] args) {
        String[] words = {"v", "123456", "ywertq", "testing", "taw", "soft", "earr"};

        for (int i = 0; i < words.length; i++) {
            if (i % 2 == 0) {
                char charWord[] = words[i].toCharArray();
                int charLength  = charWord.length - 1;
                char temp       = charWord[0];

                charWord[0] = charWord[charLength];
                charWord[charLength] = temp;

                words[i] = new String (charWord);
            }
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

    }
}
