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
import main.java.by.epam.motogarage.externalSources.ReadJSON;
import main.java.by.epam.motogarage.externalSources.ReadXML;
import main.java.by.epam.motogarage.mototechnictype.Mototechnics;

import java.io.IOException;
import java.util.*;

public abstract class Main {
    private static int maxPower;
    private static int minPower;

    public static void main(String[] args) throws IOException, ToSmallParam {

        ArrayList<Mototechnics> motoList = new ArrayList<>();

        ReadFile.read(motoList);
        ReadJDBC.read(motoList);
        ReadXML.read(motoList);
        ReadJSON.read(motoList);

        printArrayList(motoList);

        calculateCostGarage(motoList);

        System.out.println("\nSort by weight");

        //sort by weight
        Collections.sort(motoList, new CustomComparatorArrayList());

        printArrayList(motoList);

        enterPower();

        findPower(motoList);
        //PrintFile.writeDataToFile(motoList, "D:\\out.txt");

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
        for (Mototechnics m : list) {
            if (m.getPower() >= minPower && m.getPower() <= maxPower) {
                System.out.printf("Power of %s: %s", m.getModel(), m.getPower());
                System.out.println();
            }
        }
    }
}