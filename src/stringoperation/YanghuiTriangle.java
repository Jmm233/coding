package stringoperation;

import java.util.Scanner;

/**
 * @ClassName YanghuiTriangle
 * @Description 杨辉三角变形
 * @date 2021/5/19 9:10
 * @Version 1.0
 */
public class YanghuiTriangle {

    public static int getYanghui(int n) {
        if (n == 1 || n == 2) {
            return -1;
        }
        if (n % 2 == 1) {
            return 2;
        } else {
            if (n % 4 == 0) {
                return 3;
            }
            else {
                return 4;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getYanghui(n));
        }
    }
}
