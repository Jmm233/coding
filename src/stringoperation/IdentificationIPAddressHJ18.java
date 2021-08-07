package stringoperation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @ClassName IdentificationIPAddress
 * @Description 识别有效IP地址和掩码并进行分析
 * @date 2021/5/7 21:30
 * @Version 1.0
 * https://www.nowcoder.com/practice/de538edd6f7e4bc3a5689723a7435682?tpId=37&tqId=21241&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class IdentificationIPAddressHJ18 {
    /**
     * 255.255.255.255 为非法子网掩码（题目的意思，实际这个掩码，也能用）
     * 当子网掩码错误时，不在判断ip是否有效，错误直接加一， 进行下次循环
     * 当一个ip属于ABCDE类中的一个时候，也属于私有ip时，私有ip和他属于的分类都应该加一
     */
    public static String summaryIPs(LinkedList<String> strs) {
        // A B C D E 错误IP/掩码 私有IP
        int[] ans = {0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < strs.size(); i++) {
            String[] tempS = strs.get(i).split("~");
            // 分析子网掩码
            if (!isValidMask(tempS[1])) {
                ans[5] += 1;
                continue;
            }

            // 分析IP地址
            int[] indexs = isValidIP(tempS[0]);
            if (indexs[0] == -2) {
                continue;
            }

            if (indexs[0] == -1) { // 有问题
                ans[5] += 1;
            } else {
                ans[indexs[0]] += 1;
                if (indexs[1] != -1) {
                    ans[6] += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : ans) {
            sb.append(n);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     *
     * 对于子网掩码的特征，取反+1，整个二进制中仅存在一个1，这个时候如果说有别的1，那肯定不是子网掩码
     * @param mask
     * @return 四个数组成一个二进制的方法
     */
    // Integer的最大值 0x7fffffff 最高位是符号位，如果转换成Long的话，首位最大就应该是f了，因此这种计算就错了
    public static boolean isValidMask(String mask) {
        if ("255.255.255.255".equals(mask)) {
            return false;
        }
        String[] maskFragment = mask.split("\\.");
        if (maskFragment.length != 4) {
            return false;
        }
        int subMaskB = 0;
        int i = 3;
        // 可以用 Integer.parseInt(String, 2);
        for (String tempS : maskFragment) {
            int tempFragment = Integer.parseInt(tempS);
            subMaskB += tempFragment << (i * 8);
            i--;
        }
        subMaskB = ~subMaskB + 1;
        return (subMaskB & (subMaskB - 1)) == 0;
    }

    public static int[] isValidIP(String ip) {
        int[] ans = {-1, -1}; // 有效IP地址位置，是否是私有IP地址

        String[] ipFragment = ip.split("\\.");
        if (ipFragment.length != 4) {
            return ans;
        }
        if ("0".equals(ipFragment[0]) || "127".equals(ipFragment[0])) {
            return new int[]{-2, -2};
        }
        int[] ipFragmentDec = new int[4];
        for (int i = 0; i < 4; i++) {
            if ("".equals(ipFragment[i])) {
                return ans;
            }
            ipFragmentDec[i] = Integer.parseInt(ipFragment[i]);
            if (!inQujian(ipFragmentDec[i], 0, 255)) {
                return ans;
            }
        }

        if (inQujian(ipFragmentDec[0], 1, 126)) { // A
            ans[0] = 0;
            if (ipFragmentDec[0] == 10) {
                ans[1] = 1;
            }
        } else if (inQujian(ipFragmentDec[0], 128, 191)) { // B
            ans[0] = 1;
            if (ipFragmentDec[0] == 172 && ( inQujian(ipFragmentDec[1], 16, 31))) {
                ans[1] = 1;
            }
        } else if (inQujian(ipFragmentDec[0], 192, 223)) { // C
            ans[0] = 2;
            if (ipFragmentDec[0] == 192 && ipFragmentDec[1] == 168) {
                ans[1] = 1;
            }
        } else if (inQujian(ipFragmentDec[0], 224, 239)) {
            ans[0] = 3;
        } else if (inQujian(ipFragmentDec[0], 240, 255)){
            ans[0] = 4;
        }
        return ans;
    }

    public static boolean inQujian(int n, int from, int to) {
        return n >= from && n <= to;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        System.out.println(summaryIPs(list));
    }
}
