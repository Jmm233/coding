package stringoperation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName CoordinateMoveHj17
 * @Description 坐标移动
 * @date 2021/7/2 20:28
 * @Version 1.0
 */
public class CoordinateMoveHj17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str[] = scanner.nextLine().split(";");
            coordMove2(str);
        }
    }

    private static void coordMove2(String[] str) {
        int x = 0;
        int y = 0;
        Pattern pattern = Pattern.compile("([A|D|W|S])([\\d]+)");
        for (String s : str) {
            Matcher matcher = pattern.matcher(s);
            if (!matcher.matches()) {
                continue;
            }
            int step = Integer.parseInt(matcher.group(2));
            switch (matcher.group(1)) {
                case "A" :
                    x -= step;
                    break;
                case "D":
                    x += step;
                    break;
                case "W":
                    y += step;
                    break;
                case "S":
                    y-= step;
                    break;
            }
        }
        System.out.printf("%d,%d%n", x, y);
    }
}
