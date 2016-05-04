package main.java.by.epam.motogarage;

/*
Task:
        Дополнить объектную модель, реализованную в рамках задания 1 второй лекции. Добавить чтение данных из следующих источников:
        - из базы данных (базу данных можно выбрать самостоятельно) с использованием jdbc – драйвера;
        - из xml-файла.
        - из json-файла.
        Все источники данных должны реализовывать общий интерфейс.
*/


import main.java.by.epam.motogarage.exceptions.ToSmallParam;
import main.java.by.epam.motogarage.externalSources.ReadFile;
import main.java.by.epam.motogarage.externalSources.ReadJDBC;
import main.java.by.epam.motogarage.mototechnictype.Mototechnics;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.ATV;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import main.java.by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.IOException;
import java.util.*;

public abstract class Main {
    private static int maxPower;
    private static int minPower;
    private static String address = "D:\\test.txt";


    public static void main(String[] args) throws IOException, ToSmallParam {



        ArrayList<Mototechnics> motoList = new ArrayList<>();

        SportBikes blackbird = new SportBikes("Honda", "CBR1100xx", 300, 259, 163, 7500.50);
        blackbird.setCost(8000);
        blackbird.setIsNaked(true);
        blackbird.reduceWeight();
        blackbird.increasePower();
        blackbird.doWheelie();
        blackbird.makeSameNoise();

/*        try {
            blackbird.setPower(0);
        } catch (ToSmallParam  e){
            e.printStackTrace();
        }

        try {
            blackbird.setWeight(0);
        } catch (ToSmallParam  e){
            e.printStackTrace();
        }*/


        TouristBike european = new TouristBike("Honda", "Pan European", 200, 350, 140, 2, 40, 3000);
        european.setIsNaked(false);
        european.doWheelie();

        SportBikes cbr1000rr = new SportBikes("Honda", "CBR1000rr", 299, 200, 170, 8000);
        ATV Grizzly700 = new ATV("Yamaha", "Grizzly 700", 120, 400, 70, 15, 10000);

        motoList.add(blackbird);
        motoList.add(cbr1000rr);
        motoList.add(Grizzly700);
        motoList.add(european);


        ReadJDBC.readFromDB(motoList);

        ReadFile.readFileWithMoto(motoList, address);
/*
        try {
            printArrayList(motoList);
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }

        try {
            calculateCostGarage(motoList);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        }*/

        System.out.println("\nSort by power");

        //sort by weight
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

    private static void calculateCostGarage(ArrayList<Mototechnics> list) throws ArithmeticException {
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