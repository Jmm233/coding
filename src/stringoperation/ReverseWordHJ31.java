package stringoperation;

import java.util.LinkedList;
import java.util.Scanner;

/** HJ31
 * 一句话：String[] strs = "I am a student".split("[^a-zA-Z]+");
 * @ClassName ReverseWord
 * @Description 单词倒排
 * @date 2021/5/12 15:07
 * @Version 1.0
 */
public class ReverseWordHJ31 {
    public static void reverseWord(String word) {
        LinkedList<String> wordList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char[] chs = word.toCharArray();
        for (char c : chs) {
            if (Character.isLetter(c)) {
                sb.append(c);
            } else {
                wordList.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        if (sb.length() != 0) {
            wordList.add(sb.toString());
        }
        int i = wordList.size() - 1;
        StringBuilder res = new StringBuilder();
        for (; i >= 0; i--) {
            res.append(wordList.get(i));
            res.append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            reverseWord(str);
        }
    }
}
