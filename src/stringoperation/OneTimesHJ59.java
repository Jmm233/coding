package stringoperation;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName OneTimesHJ59
 * @Description 第一个只出现一次的字符
 * @date 2021/5/22 19:22
 * @Version 1.0
 */
public class OneTimesHJ59 {
    public static int getOneTimes(String str) {
        char[] chs = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chs.length; i++) {
            if (i != str.lastIndexOf(chs[i])) {
                set.add(chs[i]);
            } else {
                if (!set.contains(chs[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int ans = getOneTimes(str);
            if (ans == -1) {
                System.out.println(ans);
            } else {
                System.out.println(str.charAt(ans));
            }
        }
    }
}
