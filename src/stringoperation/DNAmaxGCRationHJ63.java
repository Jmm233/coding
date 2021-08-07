package stringoperation;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName DNAmaxGTRation
 * @Description DNA最高GC比例子序列HJ63
 * @date 2021/5/22 19:36
 * @Version 1.0
 */
public class DNAmaxGCRationHJ63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int lens = scanner.nextInt();
            System.out.println(getSub(str, lens));
        }
    }

    private static String getSub(String str, int lens) {
        char[] chs = str.toCharArray();
        int len = chs.length;
        int max_i = 0, max_j = 0;

        int[] arr = new int[len];
        arr[0] = (chs[0] == 'G' || chs[0] == 'C') ? 1 : 0;
        for (int i  = 1; i < len; i++) {
            char c = chs[i];
            arr[i] = (c == 'G' || c == 'C') ? arr[i - 1] + 1 : arr[i - 1];
        }

        int maxRatio = 0;
        for (int i = lens - 1; i < len; i++) {
            // 前缀和需要注意
            int maxRatio1 = i - lens >= 0 ? arr[i] - arr[i - lens] : arr[i];
            if (maxRatio1 > maxRatio) {
                maxRatio = maxRatio1;
                max_i = i - lens + 1;
                max_j = i;
            }
        }
        return str.substring(max_i, max_j + 1);
    }
}
