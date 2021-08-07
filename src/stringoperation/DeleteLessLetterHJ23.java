package stringoperation;

import java.util.HashMap;
import java.util.Scanner;

/*
    删除频率最少的字符
    HJ23
    https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9?tpId=37&tqId=21246&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class DeleteLessLetterHJ23 {
    public static String deleteLess(String word) {
        char[] chs = word.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int min = map.get(chs[0]);

        for (char c : map.keySet()) {
            if (min > map.get(c)) {
                min = map.get(c);
            }
        }
        // !!!!!
        for (char c : chs) {
            if (min != map.get(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            //
            System.out.println(deleteLess(str));
        }

    }
}
