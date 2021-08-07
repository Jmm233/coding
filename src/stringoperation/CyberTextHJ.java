package stringoperation;

import java.util.Scanner;

/** 注意：大小写都存在的情况下，可以考虑将整个串转变为统一大小写，再进行处理。
 * @ClassName CyberTextHJ36
 * @Description 明文加密
 * @date 2021/5/13 21:08
 * @Version 1.0
 */
public class CyberTextHJ {
    public static String getCybetText(String key, String text) {
        StringBuilder sb = new StringBuilder(key);

        for (int i = 0; i < sb.length(); i++) {
            String temp = String.valueOf(sb.charAt(i));
            int k = i + 1;
            int index = sb.indexOf(temp, k);
            while (k < sb.length() && index != -1) {
                sb.deleteCharAt(index);
                index = sb.indexOf(temp, ++k);
            }
        }

        //  key = key.toLowerCase();//可以都转成小写进行处理
        for (int i = 0; i < 26; i++) {
            char tempc = (char) (i + 'a');
            char tempC = (char) (i + 'A');
            if (sb.indexOf(String.valueOf(tempC)) != -1 || sb.indexOf(String.valueOf(tempc)) != -1) {
                continue;
            } else {
                sb.append(tempC);
            }
        }

        StringBuilder res = new StringBuilder();
        char[] chs = text.toCharArray();
        for (char c : chs) {
            if (Character.isUpperCase(c)) {
                res.append(Character.toUpperCase(sb.charAt(c - 'A')));
            } else {
                res.append(Character.toLowerCase(sb.charAt(c - 'a')));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String key = scanner.nextLine();
            String text = scanner.nextLine();
            System.out.println(getCybetText(key, text));
        }
    }
}
