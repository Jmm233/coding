package stringoperation;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @ClassName ExpressResultHJ50
 * 参考：
 * https://blog.csdn.net/zzucsliang/article/details/25282249?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-12.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-12.control
 * @Description 算术表达式求值
 * @date 2021/5/14 21:17
 * @Version 1.0
 */
public class ExpressResultHJ50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(expressResult(str));
        }
    }

    // 将全部负数前添加零。如果是第一个符号为“-”，或者“-”前为“{[(”的话为负号，需要处理。
    private static String change(String exp) {//中括号特殊字符正则表达式
        // https://www.runoob.com/regexp/regexp-syntax.html
        // ?=、?<=、?!、?<!
//        (?<![0-9)}\]])(?=-[0-9({\[])
        // 不是数字、)}]的后面  负号的前面插入0
        // 加减乘除({[的后面
        exp=exp.replaceAll("(?<=[+\\-*/({\\[])(?=-[0-9({\\[])", "0");
        exp=exp.replaceAll("[\\[]","(");
        exp=exp.replaceAll("[\\]]",")");
        exp=exp.replaceAll("[\\{]","(");
        exp=exp.replaceAll("[\\}]",")");
//        System.out.println(exp);
        return exp;
    }
    private static int expressResult(String str) {
        str = change(str);
        StringTokenizer tokenizer = new StringTokenizer(str, "+-*/()", true);
        Stack<Integer> numberStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();
        Map<String, Operator> operator = getOperator(); // 获取运算符信息
        char[] chs = str.toCharArray();
        String currentEle;
        while (tokenizer.hasMoreTokens()) {
            currentEle = tokenizer.nextToken().trim();
            if ("".equals(currentEle)) {
                continue;
            }

            if (isNumber(currentEle)) {
                numberStack.add(Integer.parseInt(currentEle));
            } else { // 操作符
                Operator currentOper = operator.get(currentEle);
                if (currentOper != null) {
                    while (!operatorStack.empty() && operatorStack.peek().priority() >= currentOper.priority())  {
                        compute(numberStack, operatorStack);
                    }
                    operatorStack.add(currentOper);
                } else { // 括号
                    if ("(".equals(currentEle)) {
                        operatorStack.add(Operator.BRACKETS);
                    } else {
                        while (!operatorStack.peek().equals(Operator.BRACKETS)) {
                            compute(numberStack, operatorStack);
                        }
                        operatorStack.pop();
                    }
                }
            }
        }
        while (!operatorStack.empty()) {
            compute(numberStack, operatorStack);
        }
        return numberStack.pop();
    }

    private static boolean isNumber(String str) {
//        ^:从字符串开头进行匹配
//        $:从字符串末尾进行匹配
//        如对于字符串“aaaAAA”
//        ^((?![A-Z]).)*仍会匹配到“aaaAAA"
//        而^((?![A-Z]).)*$才能保证不匹配。
        return Pattern.matches("^\\d+(\\.\\d+)?$", str);
    }

    private static void compute(Stack<Integer> numberStack, Stack<Operator> operatorStack) {
        int num2 = numberStack.pop();
        int num1 = numberStack.pop();
        int result = operatorStack.pop().compute(num1, num2);
        numberStack.add(result);
    }

    private static Map<String, Operator> getOperator() {
        return new HashMap<String, Operator>() {
          private static final long serialVersionUID = 7706718608122369958L;
            {
                put("+", Operator.PLUS);
                put("-", Operator.MINUS);
                put("*", Operator.MULTIPLY);
                put("/", Operator.DIVIDE);
            }
        };
    }

    private enum Operator {
        PLUS {
            @Override
            public int priority() {
                return 1;
            }
            @Override
            public int compute(int num1, int num2) {
                return num1 + num2;
            }
        },

        MINUS {
            @Override
            public int priority() {
                return 1;
            }

            @Override
            public int compute(int num1, int num2) {
                return num1 - num2;
            }
        },

        MULTIPLY {
            @Override
            public int priority() {
                return 2;
            }
            
            @Override
            public int compute(int num1, int num2) {
                return num1 * num2;
            }
        },
        
        DIVIDE {
            @Override
            public int priority() {
                return 2;
            }

            @Override
            public int compute(int num1, int num2) {
                return num1 / num2;
            }
        },
        
        BRACKETS {
            @Override
            public int priority() {
                return 0;
            }

            @Override
            public int compute(int num1, int num2) {
                return 0;
            }
        };
        
        /**
         * 对应的优先级 
         * @return
         */
        public abstract int priority();

        /**
         * 计算两个数对应的运算结果 
         * @param num1  第一个运算数 
         * @param num2  第二个运算数 
         * @return
         */
        public abstract int compute(int num1, int num2);
    }

}
