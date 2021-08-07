package stringoperation;

import java.util.HashSet;
import java.util.Scanner;

/*
    统计字符个数
    HJ10
    https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&tqId=21233&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class CountLetter {
    public static int getCountLetter(String str) {
        HashSet<Character> set = new HashSet<>();
        char[] chs = str.toCharArray();
        for (char c : chs) {
            set.add(c);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(getCountLetter(str));
    }
}
