import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validate {
    private BufferedReader br;

    public Validate() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    int getIntLimit(String msg, int min, int max) {
        String input;
        int output;
        do {
            System.out.println(msg);
            try {
                input = br.readLine();
            } catch (IOException e) {
                System.out.println("Invalid input!");
                continue;
            }
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty!");
                continue;
            } else {
                try {
                    output = Integer.parseInt(input);
                    if (output <= max && output >= min) {
                        break;
                    } else {
                        System.out.println("Invalid input!");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                }
            }
        } while (true);
        return output;
    }

    int getMatrix(String msg) {
        String input;
        int output;
        do {
            System.out.println(msg);
            try {
                input = br.readLine();
            } catch (IOException e) {
                System.out.println("Invalid input!");
                continue;
            }
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty!");
            } else {
                try {
                    output = Integer.parseInt(input);
                    break;
                } catch (Exception e) {
                    System.out.println("Value of matrix must be an integer value");
                }
            }
        } while (true);
        return output;
    }

    int[][] getMatrix1() {
        int row = getIntLimit("Enter the row of matrix1: ", 1, Integer.MAX_VALUE);
        int collum = getIntLimit("Enter the collum of matrix1: ", 1, Integer.MAX_VALUE);
        int[][] matrix = new int[row][collum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < collum; j++) {
                String message = String.format("Enter Matrix1" + "[%d][%d]", i + 1, j + 1);
                matrix[i][j] = getMatrix(message);
            }
        }
        return matrix;
    }

    int[][] getMatrix2(int[][] matrix1, int choice) {
        int[][] matrix2 = null;
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2, col2;
        if (choice == 3) {
            do {
                row2 = getIntLimit("Enter the row of Matrix2: ", 1, Integer.MAX_VALUE);
                if (row2 != col1) {
                    System.out.println("Row of matrix2 must equal column of matrix1!");
                    continue;
                }
                col2 = getIntLimit("Enter the column of Matrix2: ", 1, Integer.MAX_VALUE);
                break;
            } while (true);
        } else {
            do {
                row2 = getIntLimit("Enter row of Matrix2: ", 1, Integer.MAX_VALUE);
                if (row2 != row1) {
                    System.out.println("Row of Matrix 2 must equal row of Matrix1!");
                    continue;
                } else {
                    break;
                }
            } while (true);

            do {
                col2 = getIntLimit("Enter the column of Matrix2: ", 1, Integer.MAX_VALUE);
                if (col2 != col1) {
                    System.out.println("Column of Matrix 2 must equal column of Matrix1!");
                    continue;
                } else {
                    break;
                }
            } while (true);
        }
        matrix2 = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                String message = String.format("Enter Matrix2" + "[%d][%d]: ", i + 1, j + 1);
                matrix2[i][j] = getMatrix(message);
            }
        }
        return matrix2;
    }
}
