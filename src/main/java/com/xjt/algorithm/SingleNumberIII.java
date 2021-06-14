package com.xjt.algorithm;

/**
 * 只出现一次的数字 III
 * 
 * @author kevin
 * @date 2021/4/4
 */
public class SingleNumberIII {

    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
     *
     * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     *
     * 思路：用异或的位运算解决。（异或的话，每个数跟他自身异或结果是0，每个数和0异或的结果还是它自身）
     *
     * 对所有的数异或，最终的数就是这两个元素异或的结果，然后对这个结果做正负数与运算，得到的结果是：
     *
     * 位运算bitmask &= -bitmask;表示的是把bitmask二进制中最右边的1保留，其他位置全部变为0
     *
     */

    public int[] singleNumber(int[] nums) {

        int bitmask = 0;
        // 把数组中的所有元素全部都异或一遍
        for (int num : nums) {
            bitmask ^= num;
        }
        // 因为异或运算的结果不一定都是2的n次幂，
        // 在二进制中可能会有多个1，为了方便计算
        // 我们只需保留其中的任何一个1，其他的都
        // 让他变为0，这里保留的是最右边的1
        bitmask &= -bitmask;
        int[] rets = {0, 0};
        for (int num : nums) {
            // 然后再把数组分为两部分，每部分在
            // 分别异或
            if ((num & bitmask) == 0) {
                rets[0] ^= num;
            } else {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
