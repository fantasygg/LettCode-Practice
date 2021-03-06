package lettcode.largest_perimeter_triangle;

import java.util.Arrays;

/**
 *  #976 三角形的最大周长
 *  https://leetcode-cn.com/problems/largest-perimeter-triangle/
 *
 *  给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 *  如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 *
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 *
 * 输入：[3,6,2,3]
 * 输出：8
 *
 * 提示：
 *
 * 1.  3 <= A.length <= 10000
 * 2.  1 <= A[i] <= 10^6
 */
public class Solution {

    public static void main(String[] args) {
        // int[] A = new int[]{1,2,1};
        // int[] A = new int[]{2,1,2};
        // int[] A = new int[]{3,2,3,4};
        int[] A = new int[]{3,6,2,3};
        System.out.println(largestPerimeter(A));
    }

    /**
     * 解题思路：
     *     符合三角形的条件：两边之和大于第三边，a+b>c
     *     对数组进行排序，将最后一个最大的数视为c，
     *     只要符合c的前两个数之和大于c即可，
     *     遍历数组，找出符合要求的一组
     */
    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i+1] > A[i+2]) {
                return A[i] + A[i+1] + A[i+2];
            }
        }
        return 0;
    }
}
