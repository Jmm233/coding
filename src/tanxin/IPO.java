package tanxin;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
    IPO问题
    https://leetcode-cn.com/problems/ipo/
 */
public class IPO {
    public class IPOInfo {
        int Pro;
        int Cap;
        public IPOInfo(int p, int c) {
            Pro = p;
            Cap = c;
        }
    }

    public class minCap implements Comparator<IPOInfo> {

        @Override
        public int compare(IPOInfo o1, IPOInfo o2) {
            return o1.Cap - o2.Cap;
        }
    }

    public class maxPro implements Comparator<IPOInfo> {

        @Override
        public int compare(IPOInfo o1, IPOInfo o2) {
            return o2.Pro - o1.Pro;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<IPOInfo> minC = new PriorityQueue<>(new minCap());
        PriorityQueue<IPOInfo> maxP = new PriorityQueue<>(new maxPro());
        for (int i = 0; i < capital.length; i++) {
            minC.offer(new IPOInfo(profits[i], capital[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minC.isEmpty() && minC.peek().Cap <= w) {
                maxP.offer(minC.poll());
            }
            if (maxP.isEmpty()) {
                return w;
            }
            w += maxP.poll().Pro;
        }
        return w;
    }
}
