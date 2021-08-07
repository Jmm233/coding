package stringoperation;

import java.util.Scanner;

/** 不单单以字符串作为输入
 * @ClassName StudyEngLishHJ42
 * @Description 数字用英文念出来，学不好英语，连题都不会做...先拿翻译软件翻了翻...
 * @date 2021/5/14 11:27
 * @Version 1.0
 */
public class StudyEnglishHJ42 {
    private static String ones[] = {"zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nighteen"};
    private static String twenties[] = { "zero","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety" };

    public static String recur(long n) {
        if (n >= 1e6) {
            return recur((long) (n / 1e6)) + " million " + recur((long) (n % 1e6));
        }
        if (n >= 1e3) {
            return recur((long) (n / 1e3)) + " thousand " + recur((long) (n % 1e3));
        }
        if (n >= 1e2) {
            return recur((long) (n / 1e2)) + " hundred and " + recur((long) (n % 1e2));
        }
        if (n <= 19) {
            return ones[(int) n];
        }
        if (n % 10 == 0) {
            return twenties[(int) (n / 10)];
        }
        return twenties[(int) (n / 10)] + " " + ones[(int) (n % 10)];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Long n = scanner.nextLong();
            System.out.println(recur(n));
        }
    }

}
