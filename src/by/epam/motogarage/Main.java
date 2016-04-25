package by.epam.motogarage;

import by.epam.motogarage.mototechnictype.Mototechnics;
import by.epam.motogarage.mototechnictype.motorcycle.ATV;
import by.epam.motogarage.mototechnictype.motorcycle.SportBikes;
import by.epam.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.File;
import java.util.*;

public abstract class Main {
    public static void main(String[] args) {

        ArrayList<Mototechnics> motoList = new ArrayList<>();

        SportBikes drozd = new SportBikes("Honda", "CBR1100xx", 300, 259, 163, 7500.50);
        drozd.setCost(8000);
        drozd.setIsNaked(true);
        drozd.reduceWeight();
        drozd.increasePower();
        drozd.doWheelie();
        drozd.makeSameNoise();

        TouristBike european = new TouristBike("Honda", "Pan European", 200, 350, 140, 2, 40, 3000);
        european.setIsNaked(false);
        european.doWheelie();

        SportBikes cbr1000rr = new SportBikes("Honda", "CBR1000rr", 299, 200, 170, 8000);
        ATV Grizzly700 = new ATV("Yamaha", "Grizzly 700", 120, 400, 70, 15, 10000);

        motoList.add(drozd);
        motoList.add(cbr1000rr);
        motoList.add(Grizzly700);
        motoList.add(european);

        printArrayList(motoList);

        calculateCostGarage(motoList);

        //sort by power
        Collections.sort(motoList, new Comparator<Mototechnics>() {
            @Override
            public int compare(Mototechnics moto1, Mototechnics moto2) {
                return (moto2.getWeight() - moto1.getWeight());
            }
        });

        System.out.println("\nSort by weight");

        printArrayList(motoList);

        findPower(motoList);

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

    private static void findPower(ArrayList<Mototechnics> list) {
        System.out.println("Find motorcycle by your choose of Power");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter min Power ");
        int minPower = scanner.nextInt();
        System.out.println("Enter max Power ");
        int maxPower = scanner.nextInt();

        scanner.close();

        for (Mototechnics m : list) {
            if (m.getPower() >= minPower && m.getPower() <= maxPower) {
                System.out.printf("Power of %s: %s", m.getModel(), m.getPower());
                System.out.println();
            } else {
                System.out.println("Your power data is incorrect! Bye!");
                break;
            }
        }
    }

    private static void readData(){
        File file = new File("C:\\Test\\Test.txt");
        file.exists()
    }
}