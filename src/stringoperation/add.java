package stringoperation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName add
 * @Description TODO
 * @date 2021/5/22 18:46
 * @Version 1.0
 */
public class add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigInteger number1 = scanner.nextBigInteger();
            BigInteger number2 = scanner.nextBigInteger();
            System.out.println(number1.add(number2));
        }
    }
}
