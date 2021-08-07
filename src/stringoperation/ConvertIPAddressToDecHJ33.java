package stringoperation;

import java.util.Scanner;

/** 注意：移位操作、、Long类型的使用
 * @ClassName ConvertIPAddressToDecHJ33
 * @Description ip地址整个转换为一个十进制
 * @date 2021/5/12 22:30
 * @Version 1.0
 */
public class ConvertIPAddressToDecHJ33 {
    public static long convertIPtoDec(String str) {
        String[] strs = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Integer.parseInt(s, 2) 这个后面是以2进制的格式输出的
            String temps = Long.toBinaryString(Long.parseLong(s));
            while (temps.length() != 8) {
                temps = "0" + temps;
            }
            sb.append(temps);
        }
        return Long.parseLong(sb.toString(), 2);
    }

    // 十进制IP转换为段输出
    public static String convertDec2IP(String str) {
        StringBuilder sb = new StringBuilder();
        String binaryIP = Long.toBinaryString(Long.parseLong(str));
        while (binaryIP.length() != 32) {
            binaryIP = "0" + binaryIP;
        }
        for (int i = 0; i < 32; i += 8) {
            String temp = binaryIP.substring(i, i + 8);
            sb.append(Long.parseLong(temp, 2));
            sb.append(".");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static long convertIPtoDec2(String str) {
        String[] strs = str.split("\\.");
        long ans = 0;
        ans += Long.parseLong(strs[0]) << 24;
        ans += Long.parseLong(strs[1]) << 16;
        ans += Long.parseLong(strs[2]) << 8;
        ans += Long.parseLong(strs[3]);
        return ans;
    }

    public static String convertDec2IP2(String str) {
        StringBuilder sb = new StringBuilder();
        long ip = Long.parseLong(str);
        sb.append(ip >> 24);
        sb.append("\\.");
        sb.append((ip >> 16) & 255);
        sb.append("\\.");
        sb.append((ip >> 8) & 255);
        sb.append("\\.");
        sb.append(ip & 255);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ipStr = scanner.nextLine();
            String decStr = scanner.nextLine();
            System.out.println(convertIPtoDec2(ipStr));
            System.out.println(convertDec2IP2(decStr));
        }
    }
}
