package DP;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @ClassName HJ38BallLength
 * @Description TODO
 * @date 2021/7/19 21:27
 * @Version 1.0
 */
public class HJ38BallLength {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat(".000000");
        float high = sc.nextInt();
        float s = 0;
        for(int i = 1; i <= 5; i++){
            s += high + Float.parseFloat(decimalFormat.format(high/2));
            high = Float.parseFloat(decimalFormat.format(high/2));
        }
        System.out.println( s - high);
        System.out.println(high);
//        这个不好使，会存在0.300000的情况
//        System.out.printf("%.6f\n", high);
        sc.close();
    }
}
