package stringoperation;

import java.util.Locale;
import java.util.Scanner;

/**
 * @ClassName LevenshteinDistanceHJ52
 * @Description 编辑距离
 * @date 2021/5/21 8:49
 * @Version 1.0
 */
public class LevenshteinDistanceHJ52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String src = scanner.nextLine();
            String des = scanner.nextLine();
            System.out.println(getLevenshteinDistance(src, des));
        }
    }

    private static int getLevenshteinDistance(String src, String des) {
        int srcN = src.length();
        int destN = des.length();
        char[] srcChs = src.toCharArray();
        char[] destChs = des.toCharArray();
        int[][] dp = new int[srcN + 1][destN + 1];
        for (int i = 0; i <= srcN; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= destN; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= srcN; i++) {
            for (int j = 1; j <= destN; j++) {
                int cost = 1; // 替换
                if (srcChs[i - 1] == destChs[j - 1]) {
                    cost = 0; // 不动
                }
                // 删除一个
                dp[i][j] = Math.min(dp[i - 1][j - 1] + cost, dp[i - 1][j] + 1);
                // 插入一个
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
        return dp[srcN][destN];
    }
}
