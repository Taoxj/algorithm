package com.xjt.algorithm;

/**
 * 数组中的第K个最大元素
 * 
 * @author kevin
 * @date 2021/4/3
 */
public class FindKthLargestInArr {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 
     * 输出: 5
     *
     */

    /**
     * 思路：
     *
     * 快排序，如果数组按正常顺序排列的话，第k个元素的索引应该是len - k，我们可以用快排结合分而治之的思想来实现， 不用给数组全部的元素排序，只要排的那个元素索引是len - k就说明找到了
     *
     */

    public static void main(String[] args) {
        FindKthLargestInArr arr = new FindKthLargestInArr();
        int[] nums = {3, 1, 2, 4, -1, 5, 6};
        System.out.println(arr.findKthLargest(nums, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int targetIndex = len - k;

        // 下面就开始循环排序，直到找到对应的索引元素
        while (true) {
            int index = partition(nums, left, right);
            if (index == targetIndex) {
                return nums[index];
            } else if (index < targetIndex) {
                left = index + 1;
            } else {
                right = index - 1;
            }

        }
    }

    /**
     * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     *
     * 在遍历过程中保持循环不变量的语义 1、[left + 1, j] < nums[left] 2、(j, i] >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }

        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
