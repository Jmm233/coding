package stringoperation;

import java.util.Scanner;

/**
 * @ClassName RMBTransfer
 * @Description TODO
 * @date 2021/7/6 22:12
 * @Version 1.0
 */
public class RMBTransfer {
    private static final String[] ones = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private static final String[] tens = {"拾","佰","仟","万","亿"};
    private static final long[] it = {(long) 1e1, (long)1e2, (long)1e3, (long)1e4, (long)1e8};
    public static String recur(long m) {
        if ( m < 10) {
            return ones[(int) m];
        } else if (m < 100)  {
            return (m/10 == 1 ? "" : ones[(int) (m/10)]) + tens[0] + (m%10 == 0 ? "" : recur(m%10));
        } else{
            for(int i = 2; i <= 4; ++i) {
                if(m < it[i]) {
                    return recur(m/it[i-1]) + tens[i-1] + recur(m%it[i-1]);
                }
            }
            return recur(m/it[4]) + tens[4] + recur(m%it[4]);
        }
    }
    public static String renminbi(String str){
        String[] strs = str.split("\\.");
        StringBuilder sb = new StringBuilder("人民币");
        sb.append(recur(Long.parseLong(strs[0])));
        sb.append("元");
        if ("00".equals(strs[1])) {
            sb.append('整');
        } else {
            char[] chs = strs[1].toCharArray();
            if (chs[0] != '0') {
                sb.append(ones[chs[0] - '0']);
                sb.append('角');
            }
            if (chs[1] != '0') {
                sb.append(ones[chs[1] - '0']);
                sb.append('分');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(renminbi(str));
        }
    }
}
