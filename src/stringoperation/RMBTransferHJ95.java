package stringoperation;

import java.util.Scanner;

/**
 * @ClassName RMBTransferHJ95
 * @Description 人民币转换
 * @date 2021/6/10 21:32
 * @Version 1.0
 */
public class RMBTransferHJ95 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(showRMB(str));
        }
    }

    public static char[] level = {'佰', '仟', '万', '亿'};
    public static char[] numbers = {'零', '壹', '贰', '叁', '肆', '伍',
            '陆', '柒', '捌', '玖', '拾'};
    public static char[] sublevel = {'仟', '佰', '拾'};
    // 角、分、整

    private static String showRMB(String str) {
        String[] strs = str.split("\\.");
        StringBuilder sb = new StringBuilder("人民币");
        if (!"0".equals(strs[0])) {
            StringBuilder preMoney = new StringBuilder(strs[0]);
            while (preMoney.length() % 4 != 0) {
                preMoney.insert(0, '0');
            }
            int times = preMoney.length() / 4;
            int j = 0;
            int i = times;
            for (; i > 1; i--) {
                int z = 0;
                while (preMoney.charAt(j + z) == '0' && z <= 3) {
                    z++;
                }
                sb.append(getDescription(z, preMoney, j));
                sb.append(level[i]);
                j += 4;
            }
            // 万 接 千
            if (i == 1 && times != 1) {
                if (preMoney.charAt(j) == '0') {
                    sb.append('零');
                }
            }
            int z = 0;
            while (preMoney.charAt(j + z) == '0' && z <= 3) {
                z++;
            }
            sb.append(getDescription(z, preMoney, j));
            sb.append('元');
        }

        if ("00".equals(strs[1])) {
            sb.append('整');
        } else {
            char[] chs = strs[1].toCharArray();
            if (chs[0] != '0') {
                sb.append(getNumber(chs[0]));
                sb.append('角');
            }
            if (chs[1] != '0') {
                sb.append(getNumber(chs[1]));
                sb.append('分');
            }
        }
        return sb.toString();
    }

    public static char getNumber(char c) {
        return numbers[Integer.parseInt(String.valueOf(c))];
    }

    public static String getDescription(int z, StringBuilder preMoney, int curLevel) {
        StringBuilder sb = new StringBuilder();
        int cur = z;
        int right = 3;
        // 1000, 1100, 1110
        while (right >= 0 && preMoney.charAt(curLevel + right) == '0') {
            right--;
        }
        boolean preNonZero = true;
        for (; cur <= right; cur++) {
            char c = preMoney.charAt(curLevel + cur);
            // 5310
            if (cur == 2 && c == '1') {
                sb.append(sublevel[cur]);
                continue;
            }
            // 3006
            if (c == '0') {
                if (cur == 3) {
                    continue;
                }
                if (preNonZero) { // 前面非0 加上0
                    sb.append(getNumber(c));
                }
                preNonZero = false;
                continue;
            }

            sb.append(getNumber(c));
            if (cur != 3) {
                sb.append(sublevel[cur]);
            }
        }
        return sb.toString();
    }
}
