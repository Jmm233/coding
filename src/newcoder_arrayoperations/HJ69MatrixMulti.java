package arrayoperations;

import java.util.Scanner;

/**
 * @ClassName HJ69
 * @Description TODO
 * @date 2021/7/14 22:05
 * @Version 1.0
 */
public class HJ69MatrixMulti {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int[][] matrixA = getMatrix(x, y);
            int[][] matrixB = getMatrix(y, z);
            int[][] matrixC = new int[x][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    int temp = 0;
                    for (int k = 0; k < y; k++) {
                        temp += matrixA[i][k] * matrixB[k][j];
                    }
                    matrixC[i][j] = temp;
                    System.out.print(matrixC[i][j] + " ");
                }
                System.out.println("");
            }
            
        }
    }

    private static int[][] getMatrix(int x, int y) {
        int[][] matrixA = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }
        return matrixA;
    }
}
