package main.java.by.epam.testLection.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ArrayListDemo {
    public static void main(String[] args) {
        int positiveCount = 0;
        int size = 0;

        ArrayList<Double> list = new ArrayList<Double>();

        for (int i = 0; i < 10; i++) {
            Double d = new Random().nextGaussian();
            list.add(d);
        }

        System.out.println("Collection is: ");
        for (Double d : list) {
            System.out.printf("%.2f ", d);
        }
        size = list.size();

        Iterator<Double> it = list.iterator();

        while (it.hasNext()) {
            if (it.next() > 0)
                positiveCount++;
            else
                it.remove();
        }

        System.out.printf("%n Numbers that > 0: %d", positiveCount);
        System.out.printf("%n Numbers that <= 0: %d", size - positiveCount);

        System.out.println("\nThe update collection: ");
        for (Double d : list) {
            System.out.printf("%.2f ", d);
        }


    }

}
