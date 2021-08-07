package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName LastStoneWeightII1049
 * @Description 最后一块石头的最小重量
 * @date 2021/6/8 19:42
 * @Version 1.0
 */
public class LastStoneWeightII1049 {
    public int lastStoneWeightII(int[] stones) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>(new Comparator<Integer>() { // 后半拉
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(); // 前半拉
        for (int temp : stones) {
            if (maxPq.size() == 0) {
                maxPq.add(temp);
                continue;
            }
            if (minPq.size() == 0) {
                int pre = maxPq.poll();
                maxPq.add(Math.min(pre, temp));
                minPq.add(Math.max(pre, temp));
                continue;
            }
            minPq.add(temp);
            if (minPq.size() < maxPq.size() - 1) {
                minPq.add(maxPq.poll());
            }
        }
        while (!maxPq.isEmpty() && !minPq.isEmpty()) {
            int minus = minPq.poll() - maxPq.poll();
            if (minus != 0) {
                maxPq.add(minus);
                if (minPq.size() < maxPq.size() - 1) {
                    minPq.add(maxPq.poll());
                }
            }
        }
        if (maxPq.isEmpty() && minPq.isEmpty()) {
            return 0;
        } else if (maxPq.isEmpty()) {
            return minPq.poll();
        } else {
            return maxPq.poll();
        }
    }

    public int lastStoneWeightII2(int[] stones) {
        int sum = 0;
        for (int temp : stones) {
            sum += temp;
        }
        int[] dp = new int[sum / 2 + 1]; // 第j个重量处，可放最大“价值”
        for (int temp : stones) {
            for (int j = sum / 2; j >= temp; j--) {
                dp[j] = Math.max(dp[j], dp[j - temp] + temp);
            }
        }
        return sum - 2 * dp[sum / 2];
    }
}
