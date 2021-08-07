package arrayoperations;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName HJ64PositionMP3
 * @Description TODO
 * @date 2021/7/9 21:36
 * @Version 1.0
 */
public class HJ64PositionMP3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int total = scanner.nextInt();
            String str = scanner.next();
            char[] chs = str.toCharArray();
            int pos = 1;
            int start = 1;
            for (char c : chs) {
                switch (c) {
                    case 'U':
                        if (start == pos) {
                            start = start == 1 ? total - 3 : start - 1;
                        }
                        pos = pos == 1 ? total : pos - 1;
                        break;
                    case 'D':
                        if (start + 3 == pos) {
                            start = pos == total ? 1 : start + 1;
                        }
                        pos = pos == total ? 1 : pos + 1;
                        break;
                    default:
                        break;
                }
            }
            if (total < 4) {
                start = 1;
            }
            for (int i = 0; i < 3 && i < total - 1; i++) {
                System.out.print(start + i + " ");
            }
            System.out.println(start + (4 > total ? total - 1 : 3));
            System.out.println(pos);
        }
    }
}
