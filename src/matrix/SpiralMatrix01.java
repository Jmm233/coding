package matrix;

/*
    顺时针打印矩阵
    https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
    key: 边界处理
    key2: 判断矩阵为空的方法
    key3: 返回空数组的方法
 */
public class SpiralMatrix01 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] ans = new int[matrix.length * matrix[0].length];
        int Left = 0, Right = matrix[0].length - 1, Top = 0, Buttom = matrix.length - 1;
        int k = 0;
        while (true) {
            for (int i = Left; i <= Right; i++) {
                ans[k++] = matrix[Top][i];
            }
            if (++Top > Buttom) {
                break;
            }

            for (int i = Top; i <= Buttom; i++) {
                ans[k++] = matrix[i][Right];
            }
            if (--Right < Left) {
                break;
            }

            for (int i = Right; i >= Left; i--) {
                ans[k++] = matrix[Buttom][i];
            }
            if (--Buttom < Top) {
                break;
            }

            for (int i = Buttom; i >= Top; i--) {
                ans[k++] = matrix[i][Left];
            }
            if (++Left > Right) {
                break;
            }
        }
        return ans;
    }
}
