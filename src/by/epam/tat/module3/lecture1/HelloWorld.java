package by.epam.tat.module3.lecture1;

public class HelloWorld {

    public static void main(String[] args) {

        //строка для поиска
        String searchMe = "Мама мыла раму";
        //количество символов в строке
        int max = searchMe.length();
        //символ, который нужно найти в строке
        char symb = 'ы';
        //переключатель найдено/не найдено
        boolean find = false;

        for (int i = 0; i < max; i++) {
            // если символ на позиции i в строке равен искомому символу
            if (searchMe.charAt(i) == symb) {
                //переключаемся в режим "найдено" и выходим из цикла
                find = true;
                break;
            }

        }

        //выводим соответствующее сообщение: найден или не найден символ
        if (find)
            System.out.println("Символ '" + symb + "' найден в строке");
        else
            System.out.println("Символ '" + symb + "' не найден в строке");

    }
}