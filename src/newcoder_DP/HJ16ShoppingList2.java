package DP;

import java.util.Scanner;

/**
 * @ClassName HJ16ShoppingList2
 * @Description TODO
 * @date 2021/7/16 19:20
 * @Version 1.0
 */
public class HJ16ShoppingList2 {
    static class Good {
        int v;
        int vp;

        public Good(int v, int vp) {
            this.v = v;
            this.vp = vp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int money = scanner.nextInt();
            // 想要的商品数量
            int count = scanner.nextInt();
            int[] dp = new int[money + 1];
            // 0 主附件 1：附件 1 2：附件2
            Good[][] goods = new Good[count + 1][3];
            for (int i = 1; i <= count; i++) {
                int v = scanner.nextInt();
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                Good good = new Good(v, v * p);
                if (q == 0) {
                    goods[i][0] = good;
                } else {
                    if (goods[q][1] == null) {
                        goods[q][1] = good;
                    } else {
                        goods[q][2] = good;
                    }
                }
            }
            for (int i = 1; i <= count; i++) {
                for (int j = money; j >= 0 && goods[i][0] != null; j--) {
                    int max = dp[j];
                    Good master = goods[i][0];
                    if (master.v <= j && max < dp[j - master.v] + master.vp) {
                        max = dp[j - master.v] + master.vp;
                    }
                    int temp;
                    if (goods[i][1] != null) {
//                        int temp = master.v + goods[i][1].v;
                        if (j >= (temp = master.v + goods[i][1].v) && max < dp[j - temp] + master.vp + goods[i][1].vp) {
                            max = dp[j - temp] + master.vp + goods[i][1].vp;
                        }
                    }
                    if (goods[i][2] != null) {
//                        int temp = master.v + goods[i][1].v + goods[i][2].v;
                        if (j >= (temp = master.v + goods[i][1].v + goods[i][2].v) && max < dp[j - temp] + master.vp + goods[i][1].vp + goods[i][2].vp) {
                            max = dp[j - temp] + master.vp + goods[i][1].vp + goods[i][2].vp;
                        }
                    }
                    dp[j] = max;
                }
            }
            System.out.println(dp[money]);
        }
    }
}
