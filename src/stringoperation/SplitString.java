package stringoperation;

import java.util.Scanner;

/*
    字符串分隔
    每8个为一组，不足8位补位
    HJ4
    https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class SplitString {
    public static String[] splitDtring(String str) {
        int i = 0, k = 0;
        int N = str.length() % 8 == 0 ? str.length() / 8 : str.length() / 8 + 1;
        String[] ans = new String[N];
        while (i + 8 < str.length()) {
            ans[k++] = str.substring(i, i + 8);
            i += 8;
        }

        if (i < str.length() || i - 8 < str.length()) {
            i = i < str.length() ? i : i - 8;
            ans[k] = str.substring(i) + "00000000";
            ans[k] = ans[k].substring(0, 8);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] ans = splitDtring(str);
            for (String s : ans) {
                System.out.println(s);
            }
        }
    }
}
