package lettcode.lemonade_change;

/**
 * #860 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/
 *
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 示例 1：
 *
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 *
 * 输入：[5,5,10]
 * 输出：true
 * 示例 3：
 *
 * 输入：[10,10]
 * 输出：false
 * 示例 4：
 *
 * 输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 *
 *
 * 提示：
 *
 * 0 <= bills.length <= 10000
 * bills[i] 不是 5 就是 10 或是 20
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        int[] bills1 = new int[]{5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
        System.out.println(lemonadeChange(bills1));
    }

    /**
     * 直接遍历：
     *      1. 5元 不用找
     *      2. 10元 找一张5元
     *      3. 20元 找一张10元一张5元 或 3张5元
     *
     *      假设： five 为 5元的数量
     *            ten 为 10元的数量
     *      收到5元不用找零，直接five++;
     *      收到10元需要判断，之后执行 five--,ten++;
     *      收到20元需要判断10元和5元的数量，执行ten--,five-- 或 five-3
     */
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i : bills) {
            if (i == 5) {
                // 不用找
                five++;
            } else {
                // 找零
                if (five < 1) {
                    return false;
                }

                if (i == 10) {
                    five--;
                    ten++;
                } else {
                    if (ten > 0) {
                        // 找零
                        ten--;
                        five--;
                    } else if (five >= 3) {
                        // 找零
                        five = five - 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
