package stringoperation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName MaxLengthNumber
 * @Description 连续最长数字串
 * @date 2021/7/2 19:16
 * @Version 1.0
 */
public class MaxLengthNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            printMaxLenNumber(str);
        }
    }

    private static void printMaxLenNumber(String str) {
        Pattern pattern = Pattern.compile("(\\d)+");
        Matcher matcher = pattern.matcher(str);
        int maxLen = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            maxLen = Math.max(maxLen, matcher.group().length());
            arrayList.add(matcher.group());
        }
        for (String tempS : arrayList) {
            if (tempS.length() == maxLen) {
                sb.append(tempS);
            }
        }
        System.out.printf("%s,%s%n", sb, maxLen);
    }
}
