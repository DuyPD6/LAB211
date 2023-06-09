public class Controller {
    Validate validate = new Validate();
    BO bo = new BO();
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] result;

    void additionMatrix(int choice) {
        matrix1 = validate.getMatrix1();
        matrix2 = validate.getMatrix2(matrix1, choice);
        result = bo.additionMatrix(matrix1, matrix2);
        bo.displayResult(matrix1, matrix2, result, choice);
    }

    void subtractionMatrix(int choice) {
        matrix1=validate.getMatrix1();
        matrix2=validate.getMatrix2(matrix1, choice);
        result=bo.subtractionMatrix(matrix1, matrix2);
        bo.displayResult(matrix1, matrix2, result, choice);
    }

    public void multiplicationMatrix(int choice){
        matrix1 = validate.getMatrix1();
        matrix2=validate.getMatrix2(matrix1, choice);
        result=bo.multiplicationMatrix(matrix1, matrix2);
        bo.displayResult(matrix1, matrix2, result, choice);
    }
}
