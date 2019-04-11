package lettcode.palindrome_number;

/**
 * #9 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome1(100));
        System.out.println(isPalindrome1(-121));
        System.out.println(isPalindrome1(121));
        System.out.println(isPalindrome1(1221));
    }

    /**
     * 字符串翻转
     * 解题思路：
     *      首先确定几种情况：
     *          1. 负数，false
     *          2. 个位是0的，false
     *          3. 0，true
     *          所以遇到以上情况可以直接返回结果
     *      利用StringBuilder的reverse()方法，将翻转后的结果与原结果进行对比
     *
     */
    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x > 0) {
            if (x % 10 != 0) {
                String i = Integer.toString(x);
                StringBuilder builder = new StringBuilder(i);
                return builder.reverse().toString().equals(i);
            }
        }
        return false;
    }

    /**
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     *
     *   直接翻转数字
     *
     *      对原数字: x % 10,取得最后一位，
     *      接下来取倒数第二位，就需要 x / 10，将最后一位数字去掉，
     *      直到翻转后的数字大于删减后的x，此时又有两种情况：
     *          1. 121 此类数字，需要处理后，将中间的数字去掉再与x比较
     *          2. 1221 此类数字可以直接比较
     */
    public static boolean isPalindrome1(int x){
        if (x == 0) {
            return true;
        }
        if (x > 0) {
            if (x % 10 != 0) {
                int reverseNum = 0;
                while(x > reverseNum){
                    reverseNum = x % 10 + reverseNum * 10;
                    x = x / 10;
                }
                return reverseNum == x || reverseNum /10 ==x;
            }
        }
        return false;
    }
}
