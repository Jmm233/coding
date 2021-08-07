package stringoperation;

import java.util.Scanner;

/**
 * @ClassName SplitString2
 * @Description 截取字符串HJ46
 * @date 2021/5/14 20:27
 * @Version 1.0
 */
public class SplitString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int N = Integer.parseInt(scanner.nextLine());
            System.out.println(str.substring(0, N));
        }
    }
}
