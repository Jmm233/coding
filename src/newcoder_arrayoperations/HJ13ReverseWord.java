package arrayoperations;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName HJ13ReverseWord
 * @Description TODO
 * @date 2021/7/9 20:28
 * @Version 1.0
 */
public class HJ13ReverseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] words = str.split(" ");
            LinkedList<String> list = new LinkedList<>();
            for (int i = words.length - 1; i >= 0; i--) {
                list.add(words[i]);
            }
            System.out.println(String.join(" ", list));
        }
    }
}
