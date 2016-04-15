package by.epam.secondLesson;

/*  Turn a matrix on 90 degrees clockwise
    (Повернуть матрицу на 90 градусов по часовой стрелке)*/

public class DegreeRandomMatrix {
    public static void main(String[] args) {
        int matrixSize = 4;
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }

        PrintMatrix(matrix);

        // rotate matrix
        for (int k = 0; k < matrixSize / 2; k++) {
            for (int j = k; j < matrixSize - 1 - k; j++) {
                int tmp1 = matrix[j][k];

                matrix[j][k] = matrix[matrixSize - 1 - k][j];
                matrix[matrixSize - 1 - k][j] = matrix[matrixSize - 1 - j][matrixSize - 1 - k];
                matrix[matrixSize - 1 - j][matrixSize - 1 - k] = matrix[k][matrixSize - 1 - j];
                matrix[k][matrixSize - 1 - j] = tmp1;
            }
        }

        PrintMatrix(matrix);


    }

    //print matrix
    public static void PrintMatrix(int m[][]) {
        int size = m.length;
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }


}