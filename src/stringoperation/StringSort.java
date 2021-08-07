package stringoperation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName StringSortHJ34
 * @Description 图片整理：数字排序
 * @date 2021/5/13 21:01
 * @Version 1.0
 */
public class StringSort {
    public static String sort(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(sort(str));
        }
    }
}
