package stackqueue;

/*
    滑动窗口最大值
    https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
    严格递减的队列
    关于队列中 不用add、remove，而用offer、poll的原因
    https://blog.csdn.net/onedegree/article/details/108295374
 */

import java.util.Deque;
import java.util.LinkedList;

public class MaxSliWindow02 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return nums;
        }
        Deque<Integer> dq = new LinkedList<>();
        int i = 0;
        for (; i < k; i++) {
            while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = dq.peekFirst();
        int j = 1;
        for (; i < nums.length; i++) {
            if (dq.peekFirst() == nums[i - k]) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(nums[i]);
            ans[j++] = dq.peekFirst();
        }
        return ans;
    }
}
