package stringoperation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
    字符串排序
    HJ14
    https://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723?tpId=37&tqId=21237&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class SortString {
    // 这种方法对
    // to too这两个并不起作用
    public static class StrComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = scanner.nextLine();
        }
        Arrays.sort(strs);
        for (int i = 0; i < N; i++) {
            System.out.println(strs[i]);
        }
    }
}
