package stringoperation;

import java.util.Scanner;

/**
 * 坐标移动 HJ17
 * https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29?tpId=37&tqId=21240&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */

public class CoordinateMove {
    public static int[] coordMove(String[] moves) {
        int[] pos = {0, 0};
        for (String str : moves) {
            if (str == null || str.length() == 0) {
                continue;
            }
            char beginC = str.charAt(0);
            String suffers = str.substring(1);
            int moveN = 0;
            try {
                moveN = Integer.parseInt(suffers);
            } catch (NumberFormatException e) {
                continue;
            }

            if (beginC == 'A') {
                pos[0] -= moveN;
            } else if (beginC == 'D') {
                pos[0] += moveN;
            } else if (beginC == 'W') {
                pos[1] -= moveN;
            } else if (beginC == 'S') {
                pos[1] += moveN;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str[] = scanner.nextLine().split(";");
            int[] ans = coordMove(str);
            System.out.println(ans[0] + "," + ans[1]);
        }
    }
}
