package stringoperation;

import java.util.Scanner;

/*
    x句子最后一个单词长度
    HJ1
    https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&tqId=21224&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class LengthOfLast {
    public static int getLength(String str) {
        String[] words = str.split(" ");
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(getLength(str));
        }
    }
}
