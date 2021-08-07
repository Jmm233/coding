package newcoder_arrayoperations;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @ClassName HJ003Ramdom
 * @Description 随机数
 * @date 2021/7/8 22:14
 * @Version 1.0
 */
public class HJ003Ramdom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < number; i++) {
                treeSet.add(scanner.nextInt());
            }
            for (Integer integer : treeSet) {
                System.out.println(integer);
            }

        }
    }
}
