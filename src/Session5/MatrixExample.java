package Session5;

public class MatrixExample {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,5,4},
                {9,3,5},
                {3,7,5}
        };

        printWithForEach(matrix);
        int sum = 0;
        for (int[] row : matrix) {
            for (int cell : row) {
                sum = sum + cell;
                //sum += cell
            }
        }
        System.out.println("Sum of all integers in the matrix: " + sum);

        int sumColumn[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumColumn[j] += matrix[i][j];
            }
        }
        System.out.println("Sum of each column in the matrix: " + sumColumn[0] + ", " + sumColumn[1] + ", " + sumColumn[2]);


        int newRows = matrix[0].length;
        int newColumns = matrix.length;
        int[][] newMatrix = new int[newRows][newColumns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transposed matrix:");
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printWithFor(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printWithForEach(int[][] matrix) {
        for (int[] matrixRow : matrix) {
            for (int value : matrixRow) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
