package stringoperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class ExpressValueHJ54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String pattern = "[^\\d|()（）*+\\-/]";
            if (!Pattern.compile(pattern).matcher(str).find()) {
                char[] expressions = str.toCharArray();
                // 转换表达式
                final List<Object> suffix = infixToSuffix(expressions);
                // 计算结果
                System.out.println(evaluate(suffix));
            } else {
                System.out.println(-1);
            }
        }
    }

    /**
     * 执行计算
     *
     * @param suffix 后缀表达式
     * @return 返回Integer结果
     */
    public static Integer evaluate(List<Object> suffix) {
        if (null == suffix || suffix.size() == 0) {
            return -1;
        }

        Stack<Integer> nums = new Stack<>(); // 存储数字

        for (int i = 0; i < suffix.size(); i++) {
            if (suffix.get(i) instanceof Integer) {
                // 遇到数字则入栈
                nums.push(Integer.parseInt(String.valueOf(suffix.get(i))));
            } else if (suffix.get(i) instanceof Character && nums.size() >= 2) { // 遇到运算符，执行运算
                switch (String.valueOf(suffix.get(i))) {
                    case "+":
                        nums.push(nums.pop() + nums.pop());
                        break;
                    case "-":
                        Integer pop1 = nums.pop();
                        Integer pop2 = nums.pop();
                        nums.push(pop2 - pop1);
                        break;
                    case "*":
                        nums.push(nums.pop() * nums.pop());
                        break;
                    case "/":
                        Integer denominator = nums.pop();
                        Integer numerator = nums.pop();
                        if (denominator == 0) {
                            return -1;
                        } else {
                            nums.push(numerator / denominator);
                        }
                        break;
                }
            } else {
                return -1;
            }
        }
        Integer res = 0;
        while (!nums.isEmpty()) {
            res = nums.pop();
        }
        return res;
    }

    /**
     * 中缀表达式转后缀表达式（逆波兰表达式）
     *
     * @param expressions 表达式字符串数组
     * @return 返回后缀表达式
     */
    public static List<Object> infixToSuffix(char[] expressions) {
        if (null == expressions || expressions.length == 0) {
            return null;
        }

        Stack<Character> opStack = new Stack<>();
        StringBuilder numberBuilder = new StringBuilder();
        List<Object> result = new ArrayList<>();

        for (int i = 0; i < expressions.length; i++) {
            char e = expressions[i];
            if (i == 0 && !Character.isDigit(e) && e != '(' && e != '（') {
                numberBuilder.append(e);
                continue;
            }
            if (Character.isDigit(e)) {
                // 遇到数字，拼接起来，还原原数
                numberBuilder.append(e);
            } else {
                if (numberBuilder.length() != 0) {
                    // 将还原后的数字存起来
                    result.add(Integer.parseInt(numberBuilder.toString()));
                    numberBuilder.delete(0, numberBuilder.length());
                }
                switch (e) {
                    case '+':
                    case '-':
                        // 负数
                        if (i != 0 && (expressions[i - 1] == '(' || expressions[i - 1] == '（')) {
                            numberBuilder.append(e);
                        }
                        // +和-优先级相同且最低，当栈为空或栈顶元素为（ 时直接入栈，注意，左括号只有遇到右括号才执行出栈
                        else if (opStack.isEmpty() || opStack.peek() == '(' || opStack.peek() == '（') {
                            opStack.push(e);
                        } else {
                            // 当栈不为空且栈顶元素不是左括号时，将栈元素依次输出，直到栈为空，再压入当前运算符
                            while (!opStack.isEmpty() && opStack.peek() != '(' && opStack.peek() != '（') {
                                result.add(opStack.pop());
                            }
                            opStack.push(e);
                        }
                        break;
                    case '*':
                    case '/':
                        // *和/优先级相同且大于+和-，小于括号，当栈为空或栈顶元素为（ 时直接入栈，注意，左括号只有遇到右括号才执行出栈
                        if (opStack.isEmpty() || opStack.peek() == '(' || opStack.peek() == '（') {
                            opStack.push(e);
                        } else {
                            // 当栈不为空且栈顶元素不是左括号，同时栈顶元素优先级大于等于自己时，将栈元素依次输出，直到栈为空，再压入当前运算符
                            while (!opStack.isEmpty() && opStack.peek() != '+' && opStack.peek() != '-'
                                    && !opStack.peek().equals('(') && !opStack.peek().equals('（')) {
                                result.add(opStack.pop());
                            }
                            opStack.push(e);
                        }
                        break;
                    case '(':
                    case '（':
                        // 遇到左括号直接入栈
                        opStack.push(e);
                        break;
                    case ')':
                    case '）':
                        // 遇到右括号，当栈不为空且栈顶元素不是左括号时，输出栈元素，直到栈为空或者遇到了左括号。注意这里不执行入栈操作
                        while (!opStack.isEmpty() && opStack.peek() != '(' && opStack.peek() != '（') {
                            result.add(opStack.pop());
                        }
                        // 因为遇到左括号而停止出栈时，需要将左括号出栈
                        if (!opStack.isEmpty()) {
                            opStack.pop();
                        }
                        break;
                }
            }
        }
        // 先清空builder
        if (numberBuilder.length() != 0) {
            result.add(Integer.parseInt(numberBuilder.toString()));
            numberBuilder.delete(0, numberBuilder.length());
        }
        // 最后一步，将栈中剩余元素全部输出
        while (!opStack.isEmpty()) {
            result.add(opStack.pop());
        }
        return result;
    }
}
