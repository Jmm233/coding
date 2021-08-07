package newcoder_arrayoperations;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @ClassName HJ009NoRepeatInt
 * @Description TODO
 * @date 2021/7/8 22:30
 * @Version 1.0
 */
public class HJ009NoRepeatInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            for (int i = 0; i < sb.length(); i++) {
                set.add(sb.charAt(i));
            }
            StringBuilder ans = new StringBuilder();
            for (Iterator<Character> it = set.iterator(); it.hasNext(); ) {
                char c = it.next();
                ans.append(c);
            }
            System.out.println(ans);
        }
    }
}
