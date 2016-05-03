package by.epam.secondLesson;

/*  Turn a matrix on 90 degrees clockwise
    (Повернуть матрицу на 90 градусов по часовой стрелке)*/

/*Issue
1) Добавь в программу, чтобы был выбор: вводить размер
    матрицы и заполнять её через консоль или вводить
    размер матрицы и заполнять её случайными числами        - Выполнено
2) Ввод матрицы, заполнение матрицы, разворот матрицы
    - в отдельные методы                                    - Выполнено
 */

/*Second issue
Матрица необязательно должна быть размера NxN (3x3, 4x4).
Нужно чтобы матрица была NxM (3x5, 2x2 и т.д.)              - Выполнено
*/
import java.util.Scanner;

public class DegreeRandomMatrix {
    private static int[][] matrix;

    public static void main(String[] args) {

        int rows;
        int columns;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows ");
        rows = sc.nextInt();
        System.out.println("Enter number of columns ");
        columns = sc.nextInt();
        System.out.println("Auto-generate matrix? (Y/n)");
        String choose = sc.next();

        //add regex
        if (choose.matches("y|[Yy]es")) {
            generateMatrix(rows, columns);
        } else {
            enterMatrix(rows, columns);
        }

        printMatrix(matrix);

        rotateMatrix2(matrix);

        printMatrix(matrix);

        sc.close();
    }

    //print matrix
    private static void printMatrix(int m[][]) {

        for (int i = 0; i < m[0].length; i++) {

            for (int j = 0; j < m.length; j++) {
                System.out.print(m[j][i] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //manual enter matrix
    private static void enterMatrix(int row, int column) {
        System.out.println("After every number press \"Enter\", please");
        System.out.println("Enter matrix: ");
        Scanner sc = new Scanner(System.in);

        matrix = new int[column][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[j][i] = sc.nextInt();
            }
        }
        System.out.print("\n");
    }

    //random generate matrix
    private static void generateMatrix(int row, int column) {
        matrix = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[j][i] = (int) (Math.random() * 10);
            }
        }
    }

    //rotate matrix
    private static void rotateMatrix2 (int m[][]) {

        int[][] tempMatrix = new int[m[0].length][m.length];
        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0; j < m.length; j++) {
                tempMatrix[i][j] = matrix[j][m[0].length - 1 - i];
            }
        }
        matrix = tempMatrix;
    }
}