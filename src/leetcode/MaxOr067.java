package leetcode;

/**
 * @ClassName MaxOr067
 * @Description 最大的异或
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * @date 2021/8/4 21:17
 * 题解： https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/java-qian-zhui-shu-tan-xin-by-quruijie-vvn9/
 * @Version 1.0
 */
public class MaxOr067 {
    public static int findMaximumXOR(int[] nums) {
        //构建前缀树
        Trie trie=new Trie();
        //最大的异或结果
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            //向树中添加数
            trie.add(nums[i]);
            //从树中查找与当前数的 异或和最大的数
            //如果只要一个数,则他只能异或自己,一定为0
            max=Math.max(max,trie.findMax(nums[i]));
        }
        return max;
    }


    /**
     * 前缀树
     */
    static class Trie{
        //前缀树俩个节点,一个0,一个1
        Trie[] next;

        public Trie() {
            this.next=new Trie[2];
        }

        //向前缀树中添加元素
        public void add(int num){
            Trie root=this;
            //保留31位整数的状态到前缀树中
            for(int i=30;i>=0;i--){
                //取出num中第 i+1 位的状态
                int index=num>>i & 1;
                /**
                 * 这是个坑,特别标注!!!
                 * 如果原来有,就不需要new新的,不然会覆盖原来的
                 * 坑了我一下午!!!!!!
                 */
                if(root.next[index]==null){
                    root.next[index]=new Trie();
                }
                root=root.next[index];
            }
        }

        //查找前缀树中与当前数异或最大的元素
        public int findMax(int num){
            Trie root=this;
            int res=0;
            for(int i=30;i>=0;i--){
                //取出num中第 i+1 位的状态
                int index=num>>i & 1;

                //如果这位为1,那么他希望异或0,如果为0,希望异或1
                //所以把期望坐标取反
                index ^= 1;

                //如果有期望的值,肯定走期望
                if(root.next[index]!=null){
                    //结果加上这个值
                    res |= (1 << i);
                }else{
                    //说明没有期望的值,只能走另一条路
                    //自然不需要加,当前位的值
                    index ^= 1;
                }
                root=root.next[index];
            }
            return res;
        }
    }
}
