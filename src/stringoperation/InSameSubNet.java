package stringoperation;

import java.util.Scanner;

/**
 * @ClassName InSameSubNet
 * @Description 两个IP地址是否属于同一个子网
 * @date 2021/5/13 21:35
 * @Version 1.0
 */
public class InSameSubNet {
    public static int isInSameSubNet(String maskCode, String ip1, String ip2) {
        if (!isMaskCodeValid(maskCode) || !isFormatValid(ip1) || !isFormatValid(ip2)) {
            return 1;
        }
        long maskB = getBinary(maskCode);
        long ip1B = getBinary(ip1);
        long ip2B = getBinary(ip2);
        return (ip1B & maskB) == (ip2B & maskB) ? 0 : 2;
    }

    public static boolean isFormatValid(String address) {
        String[] strs = address.split("\\.");
        if (strs.length != 4) {
            return false;
        }
        // return strs.length == 4;
        if (!inQujian(Integer.parseInt(strs[0])) || !inQujian(Integer.parseInt(strs[1])) ||
                !inQujian(Integer.parseInt(strs[2])) || !inQujian(Integer.parseInt(strs[3]))) {
            return false;
        }
        return true;
    }

    public static boolean inQujian(int n) {
        return n >= 0 && n <= 255;
    }

    // Integer的最大值 0x7fffffff 最高位是符号位，如果转换成Long的话，首位最大就应该是f了，因此这种计算就错了
    public static int getBinary(String address) {
        String[] strs = address.split("\\.");
        int binary = 0;
        binary += Integer.parseInt(strs[0]) << 24;
        binary += Integer.parseInt(strs[1]) << 16;
        binary += Integer.parseInt(strs[2]) << 8;
        binary += Integer.parseInt(strs[3]);
        return binary;
    }

    public static boolean isMaskCodeValid(String maskCode) {
        if (!isFormatValid(maskCode)) {
            return false;
        }
        int binay = getBinary(maskCode);
        binay = ~binay + 1;
        return (binay & (binay - 1)) == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String maskeCode = scanner.nextLine();
            String ip1 = scanner.nextLine();
            String ip2 = scanner.nextLine();
            System.out.println(isInSameSubNet(maskeCode, ip1, ip2));
        }
    }
}
