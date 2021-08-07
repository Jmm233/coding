package stringoperation;

import javax.sql.rowset.CachedRowSet;
import java.util.Scanner;

/*
    对字符串进行加密解密
    HJ29
    https://www.nowcoder.com/practice/2aa32b378a024755a3f251e75cbf233a?tpId=37&tqId=21252&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class EncryptionDecryption {
//    static char[] numberlist = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//    static char[] lowerLetterList = {'a', 'b', };

    public static String encryption(String sentence) {
        char[] chs = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : chs) {
            if (Character.isDigit(c)) {
                if (c - '0' == 9) {
                    sb.append('0');
//                    sb.append(numberlist[0]);
                } else {
                    sb.append((char) (c - '0' + 1 + '0'));
//                    sb.append(numberlist[c - '0' + 1]);
                }
            } else if (Character.isLetter(c)){
                if (Character.isLowerCase(c)) {
                    if (c == 'z') {
                        sb.append('A');
                    } else {
                        sb.append((char) (c - 'a' + 1 + 'A'));
                    }
                } else {
                    if (c == 'Z') {
                        sb.append('a');
                    } else {
                        sb.append((char) (c - 'A' + 1 + 'a'));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String decryption(String sentence) {
        char[] chs = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            if (Character.isDigit(c)) {
                if (c == '0') {
                    sb.append('9');
                } else {
                    sb.append((char) (c - '0' - 1 + '0'));
                }
            } else if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    if (c == 'a') {
                        sb.append('Z');
                    } else {
                        sb.append((char) (c - 'a' - 1 + 'A'));
                    }
                } else {
                    if (c == 'A') {
                        sb.append('z');
                    } else {
                        sb.append((char) (c - 'A' - 1 + 'a'));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(encryption(str1));
            System.out.println(decryption(str2));
        }
    }
}
