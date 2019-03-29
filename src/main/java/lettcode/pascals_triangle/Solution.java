package lettcode.pascals_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * #118 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(10));
    }

    /**
     * 利用多次循环
     */
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i+1);
            if (i == 0) {
                // 第一层 直接添加
                list.add(1);
            } else if (i == 1) {
                // 第二层
                list.add(1);
                list.add(1);
            }else {
                //起始点
                list.add(1);

                // 中间点
                List<Integer> list1 = lists.get(i - 1);
                int size = list1.size();
                for (int j = 0; j < size - 1; j++) {
                    list.add(list1.get(j) + list1.get(j+1));
                }

                // 结束点
                list.add(1);
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 官方题解 : 动态规划
     */
    private static List<List<Integer>> generate1(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }





}
