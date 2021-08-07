package stringoperation;

import java.util.Scanner;

/*
    x十六进制与十进制的转换
    HJ5
    https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tqId=21228&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Hex2DecConversion {
    public static int getDec(String str) {
        String num = str.substring(2, str.length());
        int ans = 0;
        int power = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c >= '0' && c <= '9') {
                ans += (c - '0') * power;
            } else if (c >= 'A' && c <= 'F') {
                ans += (c - 'A' + 10) * power;
            }
            power *= 16;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            System.out.println(getDec(str));
        }
    }
}
