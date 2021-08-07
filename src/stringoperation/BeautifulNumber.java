package stringoperation;

import java.util.*;

/**
 * @ClassName BeautifulNumberHJ45
 * @Description 字符漂亮度
 * @date 2021/5/14 20:03
 * @Version 1.0
 */
public class BeautifulNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < N; i++) {
                String str = scanner.nextLine();
                System.out.println(getBeautiful(str));
            }
        }
    }

    private static int getBeautiful(String str) {
        char[] chs = str.toCharArray();
        int[] tempArr = new int[26];
        for (char c : chs) {
            c = Character.toLowerCase(c);
            tempArr[c - 'a']++;
        }
        Arrays.sort(tempArr);
        int ans = 0, top = 26;
        for (int i = tempArr.length - 1; i > 0 ; i--) {
            ans += top * tempArr[i];
            top--;
        }
        return ans;
    }
}
