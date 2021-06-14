package com.xjt.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author kevin
 * @date 2021/4/2
 */
public class MergeInterval {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * <p>
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]] 输出：[[1,6],[8,10],[15,18]] 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
     */

    /**
     * 时间复杂度：O(nlogn)，其中 nn 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlogn)。
     *
     * 空间复杂度：O(logn)，其中 nn 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(logn) 即为排序所需要的空间复杂度。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 把集合按照最左边的数字进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; i++) {
            // L、R代表每个区间的左边和右边值
            int L = intervals[i][0];
            int R = intervals[i][1];
            // 现在分两种情况
            // 1、如果当前数组的最左边比集合中最后一个的数组的最右边要大，说明没有重合、直接放入
            // 2、有重合，就更新放入数组最后边的那个值
            if (list.size() == 0 || L > list.get(list.size() - 1)[1]) {
                list.add(new int[] {L, R});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], R);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
