package leetcode;

/**
 * @ClassName PeopleCounts16_10_2
 * @Description TODO
 * @date 2021/8/4 21:58
 * @Version 1.0
 */
public class MaxOr067_2 {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        TireTree tree = new TireTree();
        for (int n : nums) {
            tree.add(n);
            max = Math.max(max, tree.getMaxValue(n));
        }
        return max;
    }
    class TireTree {
        TireTree[] next;
        public TireTree() {
            this.next = new TireTree[2];
        }
        public void add(int num) {
            TireTree cur = this;
            for (int i = 31; i>=0; i--) {
                int index = num >> i & 1;
                if (cur.next[index] == null) {
                    cur.next[index] = new TireTree();
                }
                cur = cur.next[index];
            }
        }
        public int getMaxValue(int num) {
            int res = 0;
            TireTree cur = this;
            for (int i = 31; i >= 0; i--) {
                int index = num >> i & 1;
                index ^= 1;
                if (cur.next[index] != null) {
                    res |= (1 << i);
                } else {
                    index ^= 1;
                }
                cur = cur.next[index];
            }
            return res;
        }
    }
}
