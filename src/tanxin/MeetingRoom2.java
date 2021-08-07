package tanxin;

import org.junit.Test;

import java.util.Arrays;

/*  全程参与，获得最大价值
    https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended-ii/
 */
public class MeetingRoom2 {
    public class Event {
        int StartD;
        int EndD;
        int Value;

        public Event(int s, int e, int v) {
            StartD = s;
            EndD = e;
            Value = v;
        }
    }
    public int maxValue(int[][] events, int k) {
        //
        Arrays.sort(events, ((o1, o2) -> o1[1] - o2[1]));
        int N = events.length;
        Event[] evs = new Event[N + 1];
        for (int i = 1; i <= N; i++) {
            evs[i] = new Event(events[i - 1][0], events[i - 1][1], events[i - 1][2]);
        }

        int[][] dp = new int[N + 1][k + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                int left = 0, right = i - 1;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;
                    if (evs[i].StartD > evs[mid].EndD) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[left][j - 1] + evs[i].Value);
            }
        }
        return dp[N][k];
    }

    @Test
    public void ttest() {
        // 1,2,4],[3,4,3],[2,3,1
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        System.out.println(maxValue(events, 2));
    }
}
