package _leetcode._CONTEST._weekly._216;

import java.util.Arrays;

/**
 * @Description: 1665. 完成所有任务的最少初始能量
 * 给你一个任务数组 tasks ，其中 tasks[i] = [actuali, minimumi] ：
 * 1.actuali 是完成第 i 个任务 需要耗费 的实际能量。
 * 2.minimumi 是开始第 i 个任务前需要达到的最低能量。
 * 比方说，如果任务为 [10, 12] 且你当前的能量为 11 ，那么你不能开始这个任务。如果你当前的能量为 13 ，你可以完成这个任务，且完成它后剩余能量为 3 。
 * 你可以按照 任意顺序 完成任务。
 * 请你返回完成所有任务的 最少 初始能量。
 *
 * @Author: matreeix
 * @Date: 2020/11/24
 */

public class Solution4 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int p = 0;
        int sum = 0;
        for (int[] task: tasks) {
            p = Math.max(p, sum + task[1]);
            sum += task[0];
        }
        return p;
    }
}
