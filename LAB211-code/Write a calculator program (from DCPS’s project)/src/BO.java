public class BO {
    int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int collum1 = matrix1[0].length;
        int row2 = matrix2.length;
        int collum2 = matrix2[0].length;
        if (row1 != row2 || collum1 != collum2) {
            return null;
        }
        int [][]result = new int[row1][collum1];
    }
}
