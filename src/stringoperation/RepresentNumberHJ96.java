package stringoperation;

import java.util.Scanner;

/**
 * @ClassName RepresentNumberHJ96
 * @Description 表示数字
 * @date 2021/6/10 21:23
 * @Version 1.0
 */
public class RepresentNumberHJ96 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(showNumber(str));
        }
    }

    private static String showNumber(String str) {
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isFirst = false;
        for (char c : chs) {
            if (Character.isDigit(c) && !isFirst) {
                sb.append('*');
                isFirst = true;
            } else if (!Character.isDigit(c) && isFirst) {
                sb.append('*');
                isFirst = false;
            }
            sb.append(c);
        }
        if (Character.isDigit(chs[chs.length - 1])) {
            sb.append('*');
        }
        return sb.toString();
    }
}
