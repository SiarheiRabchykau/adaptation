package by.epam.secondLesson;

/*  Turn a matrix on 90 degrees clockwise
    (Повернуть матрицу на 90 градусов по часовой стрелке)*/

/*Issue
1) Добавь в программу, чтобы был выбор: вводить размер матрицы и заполнять её через консоль или вводить размер матрицы и заполнять её случайными числами
2) Ввод матрицы, заполнение матрицы, разворот матрицы - в отдельные методы
 */

import java.util.Scanner;

public class DegreeRandomMatrix {
    private static int[][] matrix;

    public static void main(String[] args) {

        int matrixSize;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix size ");
        matrixSize = sc.nextInt();
        System.out.println("Auto-generate matrix? (Y/n)");
        String choose = sc.next();

        if (choose.equals("y") || choose.equals("yes") || choose.equals("Yes")) {
            generateMatrix(matrixSize);
        } else {

            enterMatrix(matrixSize);

        }

        printMatrix(matrix);

        rotateMatrix(matrixSize);

        printMatrix(matrix);

        sc.close();
    }

    //print matrix
    private static void printMatrix(int m[][]) {
        int size = m.length;
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //manual enter matrix
    private static void enterMatrix(int size ) {
        System.out.println("After every number press \"Enter\", please");
        System.out.println("Enter matrix: ");
        Scanner sc = new Scanner(System.in);

        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("\n");
    }

    //random generate matrix
    private static void generateMatrix(int matrixSize) {
        matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    //rotate matrix
    private static void rotateMatrix (int matrixSize) {
        for (int k = 0; k < matrixSize / 2; k++) {
            for (int j = k; j < matrixSize - 1 - k; j++) {
                int tmp = matrix[j][k];

                matrix[j][k] = matrix[matrixSize - 1 - k][j];
                matrix[matrixSize - 1 - k][j] = matrix[matrixSize - 1 - j][matrixSize - 1 - k];
                matrix[matrixSize - 1 - j][matrixSize - 1 - k] = matrix[k][matrixSize - 1 - j];
                matrix[k][matrixSize - 1 - j] = tmp;
            }
        }
    }
}