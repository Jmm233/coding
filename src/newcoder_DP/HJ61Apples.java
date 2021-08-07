package DP;

import java.util.Scanner;

/**
 * @ClassName HJ61Apples
 * @Description TODO
 * @date 2021/7/17 9:31
 * @Version 1.0
 */
public class HJ61Apples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int apples = scanner.nextInt();
            int pans = scanner.nextInt();
            System.out.println(solution(apples, pans));
        }
    }

    private static int solution(int apples, int pans) {
        if (apples < 0) {
            return 0;
        }
        if (apples == 1 || pans == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i <= pans; i++) {  // 剩下几个空盘
            res += onEmpty(apples, pans - i);
        }
        return res;
    }

    private static int onEmpty(int apples, int pans) {
        if (pans <= 0) {
            return 0;
        }
        if (pans == 1) {
            return 1;
        }
        if (apples < pans) {
            return 0;
        }
        if (apples == pans) {
            return 1;
        }
        return solution(apples - pans, pans);
    }
}
