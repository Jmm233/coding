package stringoperation;

import java.util.*;

/*
    合并两字符串并分别排序，再对其进行十六禁止转换
    翻转二进制！！！
    HJ30
    https://www.nowcoder.com/practice/d3d8e23870584782b3dd48f26cb39c8f?tpId=37&tqId=21253&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class MergeStringHJ30 {
    public static class CharacterComp implements Comparator<Character> {

        @Override
        public int compare(Character o1, Character o2) {
            return o1.compareTo(o2);
        }
    }

    public static String sortByOddEven(String word) {
        List<Character> list1 = new LinkedList<>();
        List<Character> list2 = new LinkedList<>();
        for (int i = 0;  i < word.length(); i++) {
            if (i % 2 == 0) {
                list1.add(word.charAt(i));
            } else {
                list2.add(word.charAt(i));
            }
        }
        list1.sort(new CharacterComp());
        list2.sort(new CharacterComp());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list1.size(); i++) {
            sb.append(list1.get(i));
            if (i < list2.size()) {
                sb.append(list2.get(i));
            }
        }
        return sb.toString();
    }

    public static String mergeString(String str1, String str2) {
        String merStr = sortByOddEven(str1 + str2);
        char[] chs = merStr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            if (!String.valueOf(c).matches("[0-9A-Fa-f]")) {
                sb.append(c);
            } else {
                int dec = Integer.parseInt(String.valueOf(c), 16);
                dec = reversBit(dec);
//                dec = reverseBit2(dec);
                sb.append(Integer.toHexString(dec).toUpperCase());
            }
        }
        return sb.toString();
    }

    public static String reverseResult(int n) {
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if ((num & n) == 0) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            num = num << 1;
        }
        return sb.toString();
    }

    public static int reversBit(int n) {
        //>>>表示不带符号向右移动二进制数，移动后前面统统补0；两个箭头表示带符号移动，
        //
        //没有<<<这种运算符，因为左移都是补零，没有正负数的区别。
        n = ((n & 0xc) >>> 2) | ((n & 0x3) << 2);
        n = ((n & 0xa) >>> 1) | ((n & 0x5) << 1);
        return n;

        // 倒置
//        for(int i=0;i<4;i++){
//            sum = n%2 + sum * 2;
//            n /= 2;
//        }
    }

    public String reverseBit2(int n) {
        // 另外一种解法
        // int a = Integer.parseInt(letter, 16);
        StringBuilder stra = new StringBuilder(Integer.toBinaryString(n));
        stra.reverse();
//        System.out.println(stra);
        return stra.toString();
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String str[] = scanner.nextLine().split(" ");
//            System.out.println(mergeString(str[0], str[1]));
//        }

    }
}
