package stringoperation;

import java.util.Scanner;

/**
 * @ClassName MaxCommonSubHJ65
 * @Description 最长公共子串
 * @date 2021/5/22 20:27
 * @Version 1.0
 */
public class MaxCommonSubHJ65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(getMaxCommon(str1, str2));
        }
    }

    private static String getMaxCommon(String str1, String str2) {
        // 短 长
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int len1 = str1.length(), len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLen = 0;
        int start = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                    start = i - maxLen;
                }
            }
        }
        return str1.substring(start, start + maxLen);
    }
}
