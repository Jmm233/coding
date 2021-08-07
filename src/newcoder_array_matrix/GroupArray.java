package newcoder_array_matrix;

import java.util.LinkedList;

/*
    数组分组
    https://www.nowcoder.com/practice/9af744a3517440508dbeb297020aca86?tpId=37&tqId=21316&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey

 */
public class GroupArray {
    public boolean whetherGroup(int[] arr) {
        if (arr.length < 2) {
            return false;
        }
        int total = 0, sum3 = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : arr) {
            total += num;
            if (num % 3 == 0) {
                sum3 += num;
            } else if (num % 5 == 0) {
                continue;
            } else {
                list.add(num);
            }
        }
        if (total % 2 != 0) {
            return false;
        }
        return hasSum(list, 0, total / 2 - sum3);
    }
    public boolean hasSum(LinkedList<Integer> list, int index, int target) {
        if (index == list.size()) {
            return target == 0;
        }
        return hasSum(list, index + 1, target) || hasSum(list, index + 1, target - list.get(index));
    }
}
