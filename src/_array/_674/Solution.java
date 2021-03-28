package _array._674;

/**
 * @Description: 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * @Date: 2021/3/28
 */

public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return n;
        int start = 0, res = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] <= nums[i - 1]) {
                res = Math.max(res, i - start);
                start = i;
            }

        return Math.max(res, n - start);
    }


}
