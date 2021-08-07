package stringoperation;

import java.util.Scanner;

/**
 * @ClassName CountCharacter
 * @Description 统计字符个数
 * @date 2021/5/14 11:20
 * @Version 1.0
 */
public class CountCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            printCounts(str);
        }
    }

    private static void printCounts(String str) {
        int eng = 0, empty = 0, number = 0, others = 0;
        char[] chs = str.toCharArray();
        for (char c : chs) {
            if (Character.isLetter(c)) {
                eng++;
            } else if (Character.isDigit(c)) {
                number++;
            } else if (c == ' ') {
                empty++;
            } else {
                others++;
            }
        }
        System.out.println(eng);
        System.out.println(empty);
        System.out.println(number);
        System.out.println(others);
    }
}
