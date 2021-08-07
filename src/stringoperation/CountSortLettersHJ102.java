package stringoperation;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName CountSortLettersHJ102
 * @Description 字符个数统计
 * @date 2021/6/7 21:57
 * @Version 1.0
 */
public class CountSortLettersHJ102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(printLetters(str));
        }
    }

    private static String printLetters(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs = str.toCharArray();
        for (char c : chs) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<LetterTimes> pq = new PriorityQueue<>();
        map.forEach((k, v) -> pq.offer(new LetterTimes(k, v)));
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().c);
        }
        return sb.toString();
    }
    private static class LetterTimes implements Comparable<LetterTimes> {
        char c;
        int times;
        public LetterTimes(char c, int times) {
            this.c = c;
            this.times = times;
        }

        @Override
        public int compareTo(LetterTimes o) {
            if (this.times != o.times) {
                return o.times - this.times; // 降序
            } else {
                return (int) this.c - o.c;// 升序
            }
        }
    }
}
