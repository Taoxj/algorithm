package com.xjt.algorithm;

/**
 * 颜色分类（荷兰国旗算法）
 * 
 * @author kevin
 * @date 2021/4/17
 */
public class SortColors {

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-colors 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 实例: 输入：nums = [2,0,2,1,1,0]
     * 
     * 输出：[0,0,1,1,2,2]
     */

    /**
     * 方法三：双指针 思路与算法（时间复杂度：O(n)，空间复杂度：O(1)）
     *
     * 我们可以考虑使用指针 p0 来交换 0，p2 来交换 2。此时，p0 的初始值仍然为 0，而 p2 的初始值为 n−1。在遍历的过程中，我们需要找出所有的 0 交换至数组的头部，并且找出所有的 2 交换至数组的尾部。
     *
     * 由于此时其中一个指针 p2 ​是从右向左移动的，因此当我们在从左向右遍历整个数组时，如果遍历到的位置超过了 p2 ，那么就可以直接停止遍历了。
     *
     * 具体地，我们从左向右遍历整个数组，设当前遍历到的位置为 i，对应的元素为 nums[i]；
     *
     * 如果找到了 0，那么与前面两种方法类似，将其与 num[p0] 进行交换，并将 p0 向后移动一个位置；
     *
     * 如果找到了 2，那么将其与 nums[p2] 进行交换，并将 p2 向前移动一个位置。
     *
     * 这样做是正确的吗？可以发现，对于第二种情况，当我们将 nums[i] 与 nums[p2] 进行交换之后，新的 nums[i] 可能仍然是 2，也可能是 0。
     *
     * 然而此时我们已经结束了交换，开始遍历下一个元素nums[i+1]，不会再考虑 nums[i] 了，这样我们就会得到错误的答案。
     *
     * 因此，当我们找到 2 时，除了将 p2 指针往前移之外，我们需要不断地将其与 nums[p2] 进行交换，直到新的 nums[i] 不为 2。
     *
     * 此时，如果 nums[i] 为 0，那么对应着第一种情况；如果 nums[i] 为 1，那么就不需要进行任何后续的操作。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/ 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int len = nums.length;
        int p0 = 0, p2 = len - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                int tem = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tem;
                p2--;
            }
            // 此时，p2的位置已经确定，不用在考虑2的问题了，只需要考虑0的位置就行
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
