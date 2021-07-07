package _leetcode._hashtable._523;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 523. 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 1.子数组大小 至少为 2 ，且
 * 2.子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= sum(nums[i]) <= 2^31 - 1
 * 1 <= k <= 2^31 - 1
 * @Date: 2021/7/7
 */

public class Solution {
    /**
     * 同余定理：给定一个正整数 m，如果两个整数 a 和 b 满足 a - b 能够被 m 整除，即(a-b)/m得到一个整数，
     * 那么就称整数 a 与 b 对模 m 同余，记作a≡b(mod m)。
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();//<余数，index>
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;//计算前缀和的求余
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) return true;
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
