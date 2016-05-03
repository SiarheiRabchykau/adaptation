package by.epam.motogarage;

/*Issue
 1) Каждый метод должен выполнять одно действие.
    В методе findPower и ввод данных, и поиск, такого быть не должно.       - выполнено

 2) Вынеси компаратор в отдельный класс в таске по ООП                      - выполнено
*/

/*Task
1) Для объектной модели, реализованной в домашнем задании в рамках лекции по ООП реализовать классы пользовательских
    исключений и организовать обработку возможных исключительных ситуаций, например, если элемент отсутствует
    в коллекции, если мы не можем удалить текущий элемент и т.д. Комментарии оставлять в классах исключений.
    Создать минимум 3 пользовательских исключения и использовать минимум 5 встроенных исключений.   - nope
2) Дополнить сценарии, реализованные в домашнем задании в рамках лекции по ООП.
    Добавить чтение данных из файла / запись данных в файл, используя I/O Streams.      -выполнено



реализованы встроенные исключения:
1) PrintFile.writeDataToFile - IOException;
2) ReadFile.readFileWithMoto - IOException, FileNotFoundException;
3)
4)
5)

пользоватедьские исключения
1)метод setPower, setWeight выбрасывает exception ToSmallParam, если значение будет <=0
2)
3)

 */


/*
Task:
        Дополнить объектную модель, реализованную в рамках задания 1 второй лекции. Добавить чтение данных из следующих источников:
        - из базы данных (базу данных можно выбрать самостоятельно) с использованием jdbc – драйвера;
        - из xml-файла.
        - из json-файла.
        Все источники данных должны реализовывать общий интерфейс или наследовать общий абстрактный класс.
*/


import by.epam.motogarage.exceptions.ToSmallParam;
import by.epam.motogarage.mototechnictype.Mototechnics;
import by.epam.motogarage.mototechnictype.motorcycle.ATV;
import by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.IOException;
import java.util.*;

public abstract class Main {
    private static int maxPower;
    private static int minPower;


    public static void main(String[] args) throws IOException, ToSmallParam {

        ArrayList<Mototechnics> motoList = new ArrayList<>();

        SportBikes blackbird = new SportBikes("Honda", "CBR1100xx", 300, 259, 163, 7500.50);
        blackbird.setCost(8000);
        blackbird.setIsNaked(true);
        blackbird.reduceWeight();
        blackbird.increasePower();
        blackbird.doWheelie();
        blackbird.makeSameNoise();

        try {
            blackbird.setPower(0);
        } catch (ToSmallParam  e){
            e.printStackTrace();
        }

        try {
            blackbird.setWeight(0);
        } catch (ToSmallParam  e){
            e.printStackTrace();
        }


        TouristBike european = new TouristBike("Honda", "Pan European", 200, 350, 140, 2, 40, 3000);
        european.setIsNaked(false);
        european.doWheelie();

        SportBikes cbr1000rr = new SportBikes("Honda", "CBR1000rr", 299, 200, 170, 8000);
        ATV Grizzly700 = new ATV("Yamaha", "Grizzly 700", 120, 400, 70, 15, 10000);

        motoList.add(blackbird);
        motoList.add(cbr1000rr);
        motoList.add(Grizzly700);
        motoList.add(european);

        ReadFile.readFileWithMoto(motoList, "D:\\test.txt");

        try {
            printArrayList(motoList);
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }

        try {
            calculateCostGarage(motoList);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        }

        System.out.println("\nSort by power");

        //sort by power
        Collections.sort(motoList, new CustomComparatorArrayList());

        printArrayList(motoList);

        enterPower();

        findPower(motoList);
        PrintFile.writeDataToFile(motoList, "D:\\out.txt");

    }


    private static void printArrayList(ArrayList<Mototechnics> list) throws ArrayIndexOutOfBoundsException {

            for (Mototechnics m : list) {
                System.out.println(m.getInfo());
            }
    }

    private static void calculateCostGarage(ArrayList<Mototechnics> list) throws ArithmeticException{
        double garagePrice = 0.0;
        for (Mototechnics moto : list) {
            garagePrice += moto.getCost();
        }
        System.out.println("Cost of all motorcycle in garage: " + garagePrice);
    }

    private static void enterPower() {
        System.out.println("Find motorcycle by your choose of Power");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter min Power ");
        minPower = scanner.nextInt();
        System.out.println("Enter max Power ");
        maxPower = scanner.nextInt();
        scanner.close();
    }

    private static void findPower(ArrayList<Mototechnics> list) {
        System.out.println(list.size());
        for (Mototechnics m : list) {
            if (m.getPower() >= minPower && m.getPower() <= maxPower) {
                System.out.printf("Power of %s: %s", m.getModel(), m.getPower());
                System.out.println();
            }
        }
    }
}