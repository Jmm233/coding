package stringoperation;

import sun.awt.image.ImageWatched;

import java.util.*;

/*
    字符串排序
    https://www.nowcoder.com/practice/5190a1db6f4f4ddb92fd9c365c944584?tpId=37&tqId=21249&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class SortStringHJ26 {
    public static String strSort(String word) {
        List<Character> list = new LinkedList<>();
        char[] chs = word.toCharArray();
        for (char c : chs) {
            if (Character.isLetter(c)) {
                list.add(c);
            }
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (char c : chs) {
            if (Character.isLetter(c)) {
                sb.append(list.get(index++));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(strSort(input));
        }

    }
}
