package stringoperation;

import java.util.*;

/**
 * @ClassName SellThingsHJ98
 * @Description 自动售货系统
 * @date 2021/6/7 22:27
 * @Version 1.0
 */
public class SellThingsHJ98 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] commonds = str.split(";");
            SellSystem sellSystem = new SellSystem();
            for (String s : commonds) {
                String[] parameters = s.split(" ");
                switch (parameters[0]) {
                    case "r": // 初始化系统
                        sellSystem = new SellSystem(parameters[1], parameters[2]);
                        break;
                    case "p": // 投币
                        sellSystem.payMoney(parameters[1]);
                        break;
                    case "b": // 购买商品
                        sellSystem.buyCommodity(parameters[1]);
                        break;
                    case "c" : //退币
                        sellSystem.rebackMoney();
                        break;
                    case "q1":
                    case "q0":// q // 查询
                        System.out.println("E010:Parameter error");
                        break;
                    case "q":
                        sellSystem.query(parameters[1]);
                        break;
                    default:

                }

            }
        }
    }

    private static class CommodityInfo implements Comparable<CommodityInfo>{
        int value; // 单价
        int number; // 数量
        String name;
        public CommodityInfo(int val, int num, String name) {
            value = val;
            number = num;
            this.name = name;
        }

        @Override
        public int compareTo(CommodityInfo o) {
            if (this.number != o.number) {
                return o.number - this.number;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }

    private static class SellSystem {
        public static final int[] commodityMoney = {0, 2, 3, 4, 5, 8, 6}; // 商品单价
        public static int[] commodityNumber = new int[7]; // 商品数量
        public static int[] moneys = new int[4]; // 1, 2, 5, 10 // 不同面值数量
        public int balance = 0; // 用户投币数量/用户剩下钱数
        public HashMap<String, CommodityInfo> map = new HashMap<>();

        public SellSystem() {}
        public SellSystem(String str1, String str2) {
            String[] cm = str1.split("-");
            for (int i = 0; i < cm.length; i++) { // 商品信息
                commodityNumber[i + 1] = Integer.parseInt(cm[i]);
                map.put("A" + i, new CommodityInfo(commodityMoney[i], Integer.parseInt(cm[i]), "A" + i));
            }
            String[] mn = str2.split("-"); // 钱币面值
            for (int i = 0; i < mn.length; i++) {
                moneys[i] = Integer.parseInt(mn[i]);
            }
            System.out.println("S001:Initialization is successful");
        }

        public void payMoney(String parameter) {
            int pay = Integer.parseInt(parameter);
            if (pay != 1 && pay != 2 && pay != 5 && pay != 10) {
                System.out.println("E002:Denomination error");
                return;
            }

            if ((pay == 5 || pay == 10) && moneys[0] + moneys[1] * 2 < balance) {
                System.out.println("E003:Change is not enough, pay fail");
                return;
            }
            boolean isEmpty = true;
            for (int number : commodityNumber) {
                if (number != 0) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                System.out.println("E005:All the goods sold out");
                return;
            }
            balance += pay;
            System.out.println("S002:Pay success,balance=" + balance);
        }

        public void buyCommodity(String parameter) {
            int commodity_id = parameter.charAt(1) - '0'; // A1-A6
            if (commodity_id >= 7 || commodity_id < 1) {
                System.out.println("E006:Goods does not exist");
                return;
            }
            if (commodityNumber[commodity_id] == 0) {
                System.out.println("E007:The goods sold out");
                return;
            }
            if (commodityMoney[commodity_id] > balance) {
                System.out.println("E008:Lack of balance");
                return;
            }
            balance -= commodityMoney[commodity_id];
            commodityNumber[commodity_id] -= 1;
            CommodityInfo temp = map.get(parameter);
            map.put(parameter, new CommodityInfo(temp.value, temp.number - 1, temp.name));
            System.out.println("S003:Buy success,balance=" + balance);
        }

        public void rebackMoney() {
            if (balance == 0) {
                System.out.println("E009:Work failure");
                return;
            }
//            1 yuan coin number=0
//            2 yuan coin number=0
//            5 yuan coin number=1
//            10 yuan coin number=0
            LinkedList<String> list = new LinkedList<>();
            for (int i = 3; i >= 0; i--) {
                int coin = getCoin(i);
                int pages = balance / coin;
                pages = Math.min(pages, moneys[i]);
                balance -= pages * coin;
                moneys[i] -= pages;
                list.addFirst(coin + " yuan coin number=" + pages);
            }
            for (String s : list) {
                System.out.println(s);
            }
        }

        public void query(String parameter) {
            if (parameter.equals("0")) { // 商品信息 // 数量由大到小，相等用商品名称
                PriorityQueue<CommodityInfo> pq = new PriorityQueue<>();
                map.forEach((k, v) -> pq.offer(new CommodityInfo(v.value, v.number, v.name)));
                while (!pq.isEmpty()) {
                    CommodityInfo ctemp = pq.poll();
                    System.out.println(ctemp.name + " " + ctemp.value + " " + ctemp.number);
                }
            } else if (parameter.equals("1")){ // 存钱盒信息
                for (int i = 0; i < 4; i++) {
                    int coin = getCoin(i);
//                    1 yuan coin number=4
                    System.out.println(coin + " yuan coin number=" + moneys[i]);
                }
            } else {
                System.out.println("E010:Parameter error");
            }
        }
    }

    private static int getCoin(int index) {
        switch (index) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 5;
            default:
                return 10;
        }
    }
}
