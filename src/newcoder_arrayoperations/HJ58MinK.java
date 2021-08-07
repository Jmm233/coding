package arrayoperations;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName HJ58MinK
 * @Description TODO
 * @date 2021/7/9 21:17
 * @Version 1.0
 */
public class HJ58MinK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int totalNumber = scanner.nextInt();
            int needNumber = scanner.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < totalNumber; i++) {
                pq.add(scanner.nextInt());
            }
            LinkedList<String> list = new LinkedList<>();
            for (int i = 0; i < needNumber; i++) {
                list.add(String.valueOf(pq.poll()));
            }
            System.out.println(String.join(" ", list));
        }
    }
}
