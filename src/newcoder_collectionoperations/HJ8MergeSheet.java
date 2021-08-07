package collectionoperations;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @ClassName HJ8MergeSheet
 * @Description TODO
 * @date 2021/7/15 9:15
 * @Version 1.0
 */
public class HJ8MergeSheet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int tempK = scanner.nextInt();
                int tempV = scanner.nextInt();
                if (map.containsKey(tempK)) {
                    map.put(tempK, map.get(tempK) + tempV);
                } else {
                    map.put(tempK, tempV);
                }
            }
            for (Integer i : map.keySet()) {
                System.out.println(i +" " + map.get(i));
            }
        }
    }
}
