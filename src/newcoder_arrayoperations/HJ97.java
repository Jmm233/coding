package arrayoperations;

import java.util.Scanner;

/**
 * @ClassName HJ97
 * @Description TODO
 * @date 2021/7/15 8:47
 * @Version 1.0
 */
public class HJ97 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int zCount = 0;
        int fCount = 0;
        int sum = 0;
        while (scanner.hasNext()) {
            int temp = scanner.nextInt();
            if (temp >= 0) {
                zCount++;
                sum += temp;
            } else {
                fCount++;
            }

        }
        float ans = 0;
        if (zCount != 0) {
            ans = (float)sum / zCount;
        }
        System.out.print(fCount + " ");
        System.out.printf("%.1f\n", ans);
    }
}
