package DP;

import java.util.Scanner;

/**
 * @ClassName HJ21QiShuiPing
 * @Description TODO
 * @date 2021/7/19 21:15
 * @Version 1.0
 */
public class HJ22QiShuiPing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number != 0) {
                int ans = 0;
                while (number >= 3) {
                    ans += number / 3;
                    number = number % 3 + number / 3;
                }
                if (number == 2) {
                    ans += 1;
                }
                System.out.println(ans);
            }
        }
    }
}
