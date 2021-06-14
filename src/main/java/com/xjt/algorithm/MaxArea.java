package com.xjt.algorithm;

/**
 * 盛最多水的容器
 * 
 * @author kevin
 * @date 2021/5/16
 */
public class MaxArea {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     *
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     *
     * 输入：[1,8,6,2,5,4,8,3,7] 输出：49
     * 
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/container-with-most-water 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 思路：双指针
     *
     * 一左一右两个指针i，j。当i小于j时，每次判断 h[i]和 h[j] 哪个更短，短的话移动一位，这样乘下来的面积就很可能比之前更大、
     *
     * 具体的算法思路参考链接：https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
