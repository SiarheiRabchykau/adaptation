package by.epam.secondLesson;

public class FindSecondLengthString {
    public static void main(String[] args) {

        int maxLengthPos = 0;
        int middleLengthPos = 0;

        String[] words = {"2", "1234", "123",
                "1", "123456", "12345678",
                "12345679", "1234", "1234"};

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
    }
}