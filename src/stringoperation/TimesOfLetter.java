package stringoperation;

import java.util.Scanner;

/*
    x计算某字母出现次数
    HJ2
    https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tqId=21225&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class TimesOfLetter {
    public static int countForLetter(String sentence, String letter) {
        char[] sch = sentence.toCharArray();
        char lech = letter.toCharArray()[0];
        int count = 0;
        for (char c : sch) {
            if (c == lech) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine().toLowerCase();
        String letter = scan.nextLine().toLowerCase();
        System.out.println(countForLetter(sentence, letter));
    }
}
