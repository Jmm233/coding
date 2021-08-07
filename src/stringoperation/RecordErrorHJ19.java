package stringoperation;

import java.util.*;

/** 关键：LinkedHashMap
 * https://www.nowcoder.com/practice/2baa6aba39214d6ea91a2e03dff3fbeb?tpId=37&tqId=21242&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 * @ClassName RecordError
 * @Description 记录错误
 * @date 2021/5/10 22:43
 * @Version 1.0
 */
public class RecordErrorHJ19 {
    public static class DataInfo {
        String fileName; // 不能超过16个字符
        int lineNumber;

        // D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr
        public DataInfo(String fileName, int lineNumber) {
            String[] strTemp = fileName.split("\\\\");
            fileName = strTemp[strTemp.length - 1];
            if (fileName.length() <= 16) {
                this.fileName = fileName;
            } else {
                this.fileName = fileName.substring(fileName.length() - 16);
            }
            this.lineNumber = lineNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.fileName, this.lineNumber);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof DataInfo)) {
                return false;
            }

            DataInfo dataInfo = (DataInfo) obj;
            return this.fileName.equals(dataInfo.fileName) && this.lineNumber == dataInfo.lineNumber;
        }
    }

    public static LinkedHashMap<DataInfo, Integer> map = new LinkedHashMap<>();

    public static void reCordSingleData(String oneLine) {
        String[] temp = oneLine.split(" ");
        DataInfo dataInfo = new DataInfo(temp[0], Integer.parseInt(temp[1]));

        if (map.containsKey(dataInfo)) {
            map.put(dataInfo, map.get(dataInfo) + 1);
        } else {
            map.put(dataInfo, 1);
        }

    }

    public static void printResult() {
        int count=0;
        for(DataInfo dataInfo:map.keySet()){
            count++;
            if(count > (map.keySet().size() - 8))
                System.out.println(dataInfo.fileName + " " + dataInfo.lineNumber + " " + map.get(dataInfo));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            reCordSingleData(str);
        }
        printResult();
    }
}
