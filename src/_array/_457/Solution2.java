package _array._457;

/**
 * @Description: 双指针解决
 * @Author: caffebaby
 * @Date: 2020/2/28
 */
public class Solution2 {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // slow/fast pointer
            int j = i, k = getIndex(i, nums);
            while (nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
                if (j == k) {
                    // check for loop with only one element
                    if (j == getIndex(j, nums)) {
                        break;
                    }
                    return true;
                }
                j = getIndex(j, nums);
                k = getIndex(getIndex(k, nums), nums);
            }
            // loop not found, set all element along the way to 0
            j = i;
            int val = nums[i];
            while (nums[j] * val > 0) {
                int next = getIndex(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    public int getIndex(int curIndex, int[] nums) {//得到下一个索引
        int len = nums.length;
        return curIndex + nums[curIndex] >= 0 ? (curIndex + nums[curIndex]) % len : len + ((curIndex + nums[curIndex]) % len);
    }
}
