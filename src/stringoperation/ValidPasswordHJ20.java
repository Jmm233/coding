package stringoperation;

import java.util.Scanner;

/** HJ20
 * 字符串字串
 * @ClassName ValidPassword
 * @Description 密码验证合格程序
 * @date 2021/5/11 21:50
 * @Version 1.0
 */
public class ValidPasswordHJ20 {

    public static void isValid(String password) {
        // 1.长度超过8位
        if (password == null || password.length() <= 8) {
            System.out.println("NG");
            return;
        }

        // 2.包括大小写字母.数字.其它符号,以上四种至少三种
        char[] chs = password.toCharArray();
        int number = 0, lowleLetter = 0, upLetter = 0, others = 0;
        for (char c : chs) {
            if ((number +  lowleLetter + upLetter + others) >= 3) {
                break;
            }
            if (c >= '0' && c <= '9') {
                if (number == 0) {
                    number += 1;
                }
            } else if (c >= 'a' && c <= 'z') {
                if (lowleLetter < 1) {
                    lowleLetter += 1;
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (upLetter < 1) {
                    upLetter += 1;
                }
            } else if (others < 1){
                others += 1;
            }
        }
        if ((number +  lowleLetter + upLetter + others) < 3) {
            System.out.println("NG");
            return;
        }

        // 3.不能有相同长度大于2的子串重复
        for (int i = 0; i < password.length() - 2; i++) {
            String sub = password.substring(i, i + 3);
            if (password.substring(i + 1).contains(sub)) { // 子串是左开右闭的
                System.out.println("NG");
                return;
            }
        }

        System.out.println("OK");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            isValid(str);
        }
    }
}
