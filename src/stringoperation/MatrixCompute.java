package stringoperation;

import java.util.*;

/**
 * @ClassName MatrixCompute
 * @Description 矩阵计算量的估算
 * @date 2021/5/29 19:57
 * @Version 1.0
 */
public class MatrixCompute {
    public static class MatrixInfo {
        int m;
        int n;
        public MatrixInfo(int m, int n) {
            this.m = m;
            this.n = n;
        }

        public int getMatrixSize() {
            return m * n;
        }
    }

    public static int getComputation(MatrixInfo[] matrixs, String exp) {
        char[] chs = exp.toCharArray();
        int ans = 0;
        Stack<Object> stackSym = new Stack<>();

        for (char c : chs) {
            if (Character.isLetter(c)) {
                int index = c - 'A';
                if (!stackSym.isEmpty() && stackSym.peek() instanceof MatrixInfo) {
                    MatrixInfo temp = (MatrixInfo)stackSym.pop();
                    ans += matrixs[index].getMatrixSize() * temp.m;
                    stackSym.add(new MatrixInfo(temp.m, matrixs[index].n));
                } else {
                    stackSym.add(matrixs[index]);
                }
            } else if (c == '('){
                stackSym.add(c);
            } else {
                Stack<Object> tempStack = new Stack<>();
                while (!stackSym.isEmpty() && stackSym.peek() instanceof MatrixInfo) {
                    tempStack.add(stackSym.pop());
                }
                if (!stackSym.isEmpty()) {
                    stackSym.pop(); // '('
                }

                while (!tempStack.isEmpty() && tempStack.size() >= 2) {
                    MatrixInfo temp1 = (MatrixInfo) tempStack.pop();
                    MatrixInfo temp2 = (MatrixInfo) tempStack.pop();
                    ans += temp2.getMatrixSize() * temp1.m;
                    tempStack.add(new MatrixInfo(temp1.m, temp2.n));
                }
                if (!tempStack.isEmpty()) {
                    stackSym.add(tempStack.pop());
                }
            }

        }

//        if (!stackSym.isEmpty()) {
//            Stack<Object> tempStack = new Stack<>();
//            while (!stackSym.isEmpty()) {
//                Object temp = stackSym.pop();
//                if (temp instanceof MatrixInfo) {
//                    tempStack.add(temp);
//                }
//            }
//            while (!tempStack.isEmpty() && tempStack.size() >= 2) {
//
//                MatrixInfo temp1 = (MatrixInfo) tempStack.pop();
//                MatrixInfo temp2 = (MatrixInfo) tempStack.pop();
//                ans += temp2.getMatrixSize() * temp1.m;
//                tempStack.add(new MatrixInfo(temp1.m, temp2.n));
//            }
//        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            MatrixInfo[] matrixs = new MatrixInfo[n];
            for (int i = 0; i < n; i++) {
                matrixs[i] = new MatrixInfo(scanner.nextInt(), scanner.nextInt());
            }

            String str = scanner.next();
            System.out.println(getComputation(matrixs, str));

        }
    }
}
