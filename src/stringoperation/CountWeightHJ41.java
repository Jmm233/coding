package stringoperation;

import java.util.*;

/**注意HashSet使用：遍历时不可对其增删
 * @ClassName CountWeightHJ41
 * @Description 砝码能够称的重量
 * @date 2021/5/14 9:19
 * @Version 1.0
 */
public class CountWeightHJ41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            int[] weight = new int[number];
            int[] much = new int[number];
            for (int i = 0; i < number; i++) {
                weight[i] = scanner.nextInt();
            }
            for (int i = 0; i < number; i++) {
                much[i] = scanner.nextInt();
            }
            System.out.println(getCountWeight(number, weight, much));
        }
    }

    private static int getCountWeight(int number, int[] weight, int[] much) {
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        LinkedList<Integer> list;
        for (int i = 0; i < number; i++) {
            list = new LinkedList<>();
            for (int j = 1; j <= much[i]; j++) {
                for (Integer e : set) {
                    list.add(e + weight[i] * j);
                }
            }
            set.addAll(list);
        }
        return set.size();
    }
}
