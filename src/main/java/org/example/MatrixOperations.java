import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    private static final int MAX_SIZE = 20;
    private static final int MAX_RANDOM_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the width of the matrix (not more than 20):");
        int width = scanner.nextInt();
        System.out.println("Enter the height of the matrix (not more than 20):");
        int height = scanner.nextInt();

        int[][] matrix;

        if (width > MAX_SIZE || height > MAX_SIZE || width <= 0 || height <= 0) {
            System.out.println("Invalid matrix size. Exiting...");
            return;
        }

        System.out.println("Do you want to enter the matrix manually? (yes/no)");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("yes")) {
            matrix = createMatrixManually(width, height, scanner);
        } else {
            matrix = createRandomMatrix(width, height);
        }

        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        System.out.println("Minimum element in the matrix: " + min);
        System.out.println("Maximum element in the matrix: " + max);
        System.out.println("Average of all elements in the matrix: " + average);
        System.out.println("Geometric mean of all elements in the matrix: " + geometricMean);
    }

    private static int[][] createMatrixManually(int width, int height, Scanner scanner) {
        int[][] matrix = new int[height][width];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] createRandomMatrix(int width, int height) {
        Random random = new Random();
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_NUMBER + 1);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }
        return (double) sum / count;
    }

    private static double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                product *= num;
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }
}
