package lettcode.JewelsAndStones;

import java.util.HashSet;
import java.util.Set;

/**
 *
     给定字符串`J` 代表石头中宝石的类型，和字符串 `S`代表你拥有的石头。 `S` 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     `J` 中的字母不重复，`J` 和 `S`中的所有字符都是字母。字母区分大小写，因此`"a"`和`"A"`是不同类型的石头。

     示例 1:
     输入: J = "aA", S = "aAAbbbb"
     输出: 3

     示例 2:
     输入: J = "z", S = "ZZ"
     输出: 0

     注意:
        `S` 和 `J` 最多含有50个字母。
        `J` 中的字符不重复。
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones1("aA","aAAbbbb"));
        System.out.println(numJewelsInStones2("aA","aAAbbbb"));
    }

    /**
     * 暴力法
     */
    private static int numJewelsInStones1(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char sc = S.charAt(i);
            for (int j = 0; j < J.length(); j++) {
                if (J.charAt(j) == sc) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 利用Set集合
     *
     * 把 'J' 中的字符放到Set中，遍历 'S'，
     * 判断Set中是否有S，有则计数+1
     *
     */
    private static int numJewelsInStones2(String J, String S){
        int count = 0;

        Set<Character> setJ = new HashSet<>(J.length());

        for (Character c : J.toCharArray()) {
            setJ.add(c);
        }


        for (Character c : S.toCharArray()) {
            if (setJ.contains(c)) {

                count++;
            }
        }
        return count;
    }
}
