package stringoperation;

import java.util.Locale;
import java.util.Scanner;

/**
 * @ClassName CommMatchHJ71
 * @Description 字符串通配符
 * @date 2021/5/29 21:06
 * @Version 1.0
 */
public class CommMatchHJ71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strPattern = scanner.nextLine();
            String str = scanner.nextLine();
            System.out.println(isMatch(strPattern, str));
        }
    }

    private static boolean isMatch(String strPattern, String str) {
        char[] chsPattern = strPattern.toLowerCase().toCharArray();
        char[] chsStr = str.toLowerCase().toCharArray();
        boolean[][] dp = new boolean[chsPattern.length + 1][chsStr.length + 1];
        dp[0][0] = true;

        for (int i = 1; i <= chsPattern.length; i++) {
            dp[i][0] = dp[i - 1][0] && chsPattern[0] == '*';
            for (int j = 1; j <= chsStr.length; j++) {
                if (chsPattern[i - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (chsPattern[i - 1] == '?' || chsPattern[i - 1] == chsStr[j - 1]);
                }

            }
        }
        return dp[chsPattern.length][chsStr.length];
    }
}
