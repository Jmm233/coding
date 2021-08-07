package arrayoperations;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName HJ35SnakeMatrix
 * @Description TODO
 * @date 2021/7/9 20:42
 * @Version 1.0
 */
public class HJ35SnakeMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int start = 1;
            for (int i = 0; i < n; i++) {
                LinkedList<String> list = new LinkedList<>();
                start = start + i;
                int startj = start;
                for (int j = 0; j < n - i; j++) {
                    list.add(String.valueOf(startj));
                    startj = startj + i + j + 2;
                }
                System.out.println(String.join(" ", list));
            }
        }
    }
}
