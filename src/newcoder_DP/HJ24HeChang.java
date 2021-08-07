package DP;

import java.util.Scanner;

/**
 * @ClassName HJ24HeChang
 * @Description TODO
 * @date 2021/7/17 9:14
 * @Version 1.0
 */
public class HJ24HeChang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            int[] queue = new int[number];
            for (int i = 0; i < number; i++) {
                queue[i] = scanner.nextInt();
            }
            System.out.println(outQueue(queue));
        }
    }

    private static int outQueue(int[] nums) {
        int len = nums.length;
        if ( len == 3){
            return 0;
        }
        int[][] dp = new int[len][2];
        // dp[i][0] 以 第 i 个数字结尾 的 最长 升序 子序列
        // dp[i][1] 以 第 i 个数字为起始点 的 最长降序 子序列
        dp[0][0] = 1;
        for (int i = 1 ; i < len ; i ++) {
            for (int j = 0 ; j < i ; j ++) {
                if ( nums[i] > nums[j] ){
                    dp[i][0] = Math.max(dp[i][0] , dp[j][0] + 1);
                } else{
                    dp[i][0] = Math.max( dp[i][0] , 1);
                }
            }
        }
        dp[len - 1][1] = 1;
        for (int i = len - 2 ; i >= 0 ; i -- ){
            for (int j = len - 1 ; j > i ; j --){
                if ( nums[i] > nums[j] ){
                    dp[i][1] = Math.max(dp[i][1] , dp[j][1] + 1);
                }
                else{
                    dp[i][1] = Math.max(dp[i][1] , 1);
                }
            }
        }

        int max = 0;
        for (int i = 1 ; i < len - 1 ; i ++){
            //  System.out.println(dp[i][0] + " " + dp[i][1]);
            if ( dp[i][0] > 1 && dp[i][1] > 1 ){
                max = Math.max( max , dp[i][0] + dp[i][1] );
            }
        }
        //System.out.println("max :" + max);
        return len - max + 1;
    }
}
