package com.xjt.algorithm;

/**
 * x的平方根
 * 
 * @author kevin
 * @date 2021/4/16
 */
public class MySqrt {

    /**
     * 题目：给定一个数，算出小于并且最接近平方根的整数，比如 8 的平方根是2.44，那么最接近的整数就是2
     *
     * 思路：
     * 
     * 二分查找的下界为 0，上界可以粗略地设定为 x。在二分查找的每一步中，我们只需要比较中间元素 mid 的平方与 x 的大小关系，
     *
     * 并通过比较的结果调整上下界的范围。由于我们所有的运算都是整数运算，不会存在误差，
     *
     * 因此在得到最终的答案 ans 后，也就不需要再去尝试 ans+1 了。
     *
     * 作者：LeetCode-Solution 链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int mySqrt(int x) {
        int l = 0, r = x, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 当前中间数的平方小于目标数，那么就加大中间数
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
