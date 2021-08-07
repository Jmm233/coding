package stringoperation;

import java.util.Scanner;

/**！！！！重要！！！！思路一开始就不对
 * 动态规划/manacher
 * manacher
 * https://www.cnblogs.com/cloudplankroader/p/10988844.html
 * @ClassName CiphertextSymmetric
 * @Description 最长回文字串
 * @date 2021/5/12 15:34
 * @Version 1.0
 */
public class CiphertextSymmetricHJ32 {
    // 由某一个字符向两边扩散的思路
    public static int getMaxSymmetricLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] manaChs = manacherString(str);
        int[] radius = new int[manaChs.length];
        int right = -1, center = -1;
        int maxLength = 1;
        for (int i = 0; i < manaChs.length; i++) {
            radius[i] = right > i ? Math.min(radius[2 * center - i], right - i) : 1;
            while (i + radius[i] < manaChs.length && i - radius[i] >= 0) {
                if (manaChs[i + radius[i]] == manaChs[i - radius[i]]) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            if (right < i) {
                center = i;
                right = i + radius[i];
            }
            maxLength = Math.max(maxLength, radius[i]);
        }
        return maxLength;
    }

    public static char[] manacherString(String str) {
        char[] afterChs = new char[2 * str.length() + 1];
        char[] strChs = str.toCharArray();
        int index = 0;
        for (int i = 0; i < afterChs.length; i++) {
            afterChs[i] = (i & 1) == 0 ? '#' : strChs[index++];
        }
        return afterChs;
    }

    // 动态规划
    public static int getMaxSymmetricLength2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        int len = str.length();
        char[] chs = str.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[j][i] = true;
                } else if (i - j == 1) {
                    dp[j][i] = chs[i] == chs[j];
                } else {
                    dp[j][i] = (chs[i] == chs[j]) && dp[j + 1][i - 1];
                }
                if (dp[j][i]) {
                    maxLength = Math.max(maxLength, i - j);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(getMaxSymmetricLength(str));
        }
    }
}
