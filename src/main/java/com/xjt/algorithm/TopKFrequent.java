package com.xjt.algorithm;

import java.util.*;

/**
 * 前 K 个高频元素
 * 
 * @author kevin
 * @date 2021/4/4
 */
public class TopKFrequent {

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     *
     * 输出: [1,2]
     *
     */

    /**
     * 思路：
     *
     * 借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
     * 
     * 维护一个元素数目为 k 的最小堆
     * 
     * 每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
     * 
     * 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
     * 
     * 最终，堆中的 k 个元素即为前 k 个高频元素
     *
     *
     */

    /**
     * 时间复杂度：O(nlogk)，n 表示数组的长度。首先，遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是 O(n)；
     *
     * 接着，遍历用于存储元素频率的 map，如果元素的频率大于最小堆中顶部的元素，则将顶部的元素删除并将该元素加入堆中，
     *
     * 这里维护堆的数目是 k，所以这一系列操作的时间复杂度是 O(nlogk 的；因此，总的时间复杂度是 O(nlog⁡k)。
     *
     * 空间复杂度：O(n)，最坏情况下（每个元素都不同），map 需要存储 n 个键值对，优先队列需要存储 k
     * 
     * 个元素，因此，空间复杂度是 O(n)。
     *
     * 作者：MisterBooo
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 先用HashMap保存每个元素的个数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数，按从小到大的次数顺序排列
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(k);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }

        return res;
    }
}
