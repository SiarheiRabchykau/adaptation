package by.epam.motogarage;

/*Issue
 1) Каждый метод должен выполнять одно действие. В методе findPower и ввод данных, и поиск, такого быть не должно.

 2) Вынеси компаратор в отдельный класс в таске по ООП      -
*/

import by.epam.motogarage.mototechnictype.Mototechnics;
import by.epam.motogarage.mototechnictype.motorcycle.ATV;
import by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.IOException;
import java.util.*;

public abstract class Main {
    private static int maxPower;
    private static int minPower;


    public static void main(String[] args) throws IOException {

        ArrayList<Mototechnics> motoList = new ArrayList<>();

        SportBikes blackbird = new SportBikes("Honda", "CBR1100xx", 300, 259, 163, 7500.50);
        blackbird.setCost(8000);
        blackbird.setIsNaked(true);
        blackbird.reduceWeight();
        blackbird.increasePower();
        blackbird.doWheelie();
        blackbird.makeSameNoise();

        TouristBike european = new TouristBike("Honda", "Pan European", 200, 350, 140, 2, 40, 3000);
        european.setIsNaked(false);
        european.doWheelie();

        SportBikes cbr1000rr = new SportBikes("Honda", "CBR1000rr", 299, 200, 170, 8000);
        ATV Grizzly700 = new ATV("Yamaha", "Grizzly 700", 120, 400, 70, 15, 10000);

        motoList.add(blackbird);
        motoList.add(cbr1000rr);
        motoList.add(Grizzly700);
        motoList.add(european);

        ArrayList<Mototechnics> newMotoList = new ReadFile().readFileWithMoto(motoList);

        printArrayList(newMotoList);

        calculateCostGarage(newMotoList);

        System.out.println("\nSort by power");
        //sort by power
        Collections.sort(newMotoList, new CustomComparatorArrayList());

        printArrayList(newMotoList);

        enterPower();

        findPower(newMotoList);
    }


    private static void printArrayList(ArrayList<Mototechnics> list) {
        for (Mototechnics m : list) {
            System.out.println(m.getInfo());
        }
    }

    private static void calculateCostGarage(ArrayList<Mototechnics> list) {

        double garagePrice = 0.0;
        for (Mototechnics moto : list) {
            garagePrice += moto.getCost();
        }
        System.out.println("Cost of all motorcycle in garage: " + garagePrice);
    }

    private static void enterPower(){
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