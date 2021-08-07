package stringoperation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName ValidPassword
 * @Description 密码验证合格程序
 * @date 2021/7/2 21:54
 * @Version 1.0
 */
public class ValidPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            boolean result = isValid2(str);
            if (result) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static boolean isValid2(String str) {
        Pattern pattern = Pattern.compile("(.{3,}).*(\\1)"); //
        Matcher matcher = pattern.matcher(str);
        // str.replaceAll("(.{3,}).*(\1)", "").length() < str.length();
        // matcher.find()
        if (str.length() <= 8 || matcher.find()) {
//            System.out.println("NG");
//            System.out.println(matcher.group());
            return false;
        }
//        System.out.println(matcher.find());
        int count = 0;
        if (str.matches(".*[0-9].*")) {
            count++;
        }
        if (str.matches(".*[A-Z].*")) {
            count++;
        }
        if (str.matches(".*[a-z].*")) {
            count++;
        }
        if (str.matches(".*[^0-9a-zA-Z].*")) {
            count++;
        }
//        if (count < 3) {
//            System.out.println("NG");
//        } else {
//            System.out.println("OK");
//        }
        return count >= 3;
    }
}
