package leetcode;

import org.junit.Test;

/**
 * @ClassName Candies1744
 * @Description TODO
 * @date 2021/6/1 19:44
 * @Version 1.0
 */
public class Candies1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        long[] preCount = new long[candiesCount.length];
        preCount[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            preCount[i] = candiesCount[i] + preCount[i - 1];
        }
        long min, max;

        for (int i = 0; i < queries.length; i++) {
            min = queries[i][1] + 1; // 每天一个 吃到目标天数，吃几个
            max = (long) queries[i][2] * (queries[i][1] + 1); // 每天最多个，吃到目标天数，吃几个
            if (queries[i][0] == 0) {
                ans[i] = min <= preCount[queries[i][0]];
                continue;
            }
//            ans[i] = max > preCount[queries[i][0] - 1] && min <= preCount[queries[i][0]];
            ans[i] = (max > preCount[queries[i][0] - 1] && max <= preCount[queries[i][0]]) ||
                    (min > preCount[queries[i][0] - 1] && min <= preCount[queries[i][0]]) ||
                    (min <= preCount[queries[i][0] - 1] && max > preCount[queries[i][0]]);
        }
        return ans;
    }
    @Test
    public void ttest() {
//        [7,4,5,3,8]
//[[0,2,2],[4,2,4],[2,13,1000000000]]
        int[] arr = {7,4,5,3,8};
        int[][] quer = {{4,2,4}};
        boolean[] ans = canEat(arr, quer);
        for (int i = 0; i < quer.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
