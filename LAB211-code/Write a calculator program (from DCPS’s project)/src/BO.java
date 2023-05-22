public class BO {
    int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int collum1 = matrix1[0].length;
        int row2 = matrix2.length;
        int collum2 = matrix2[0].length;
        if (row1 != row2 || collum1 != collum2) {
            return null;
        }
        int[][] result = new int[row1][collum1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < collum1; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int collum1 = matrix1[0].length;
        int row2 = matrix2.length;
        int collum2 = matrix2[0].length;
        if (row1 != row2 || collum1 != collum2) {
            return null;
        }
        int[][] result = new int[row1][collum1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < collum1; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int collum1 = matrix1[0].length;
        int row2 = matrix2.length;
        int collum2 = matrix2[0].length;
        if (collum1 != row2) {
            return null;
        }
        int[][] result = new int[row1][collum2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < collum2; j++) {
                for (int k = 0; k < row2; k++) {
                    result[i][j] += matrix2[k][j] * matrix1[i][k];
                }
            }
        }
        return result;
    }

    void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.format("[%d]", matrix[i][j]);
            }
            System.out.println("");
        }
    }

    void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int choice) {
        System.out.println("-------------------Result-------------------");
        if (result == null) {
            System.out.println("null");
        } else {
            displayMatrix(matrix1);
            switch (choice) {
                case 1:
                    System.out.println("+");
                    break;
                case 2:
                    System.out.println("-");
                    break;
                case 3:
                    System.out.println("*");
                    break;
                default:
                    System.out.println("Input is not valid!");
                    break;
            }
            displayMatrix(matrix2);
            System.out.println("=");
            displayMatrix(result);
        }
    }
}
