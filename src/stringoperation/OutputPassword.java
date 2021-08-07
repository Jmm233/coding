package stringoperation;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName OutputPassword HJ21
 * @Description 破解简单密码
 * @date 2021/5/12 9:14
 * @Version 1.0
 */
public class OutputPassword {

    public static void crackPassword(String str) {
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            if (Character.isLowerCase(c)) {
                sb.append(getNumber(c));
            } else if (Character.isUpperCase(c)) {
                sb.append(getLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

    public static char getLowerCase(char c) {
        if (c != 'Z') {
            return (char) (c - 'A' + 1 + 'a');
        } else {
            return 'a';
        }
    }

    public static int getNumber(char c) {
        if (c < 'p') {
            int distance = c - 'a';
            return 2 + distance / 3;
//            if (distance % 3 == 0) {
//                return 1 + distance / 3;
//            } else {
//                return 2 + distance / 3;
//            }
        } else if (c <= 's') {
            return 7;
        } else if (c <= 'v') {
            return 8;
        } else {
            return 9;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            crackPassword(str);
        }
    }
}
