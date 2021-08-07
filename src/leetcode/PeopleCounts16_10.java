package leetcode;

/**
 * @ClassName PeopleCounts16_10
 * @Description 生存人数
 * https://leetcode-cn.com/problems/living-people-lcci/
 * @date 2021/8/4 20:29
 * @Version 1.0
 */
public class PeopleCounts16_10 {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] res = new int[102];
        for (int i = 0; i < birth.length; i++) {
            res[birth[i] - 1900]++;
            res[death[i] - 1900 + 1]--;
        }
        // 前缀和
        int tem = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < 101; i++) {
            tem += res[i];
            if (tem > max) {
                max = tem;
                index = i;
            }
        }
        return index + 1900;
    }
}
