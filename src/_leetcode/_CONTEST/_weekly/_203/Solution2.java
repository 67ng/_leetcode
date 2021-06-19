package _leetcode._CONTEST._weekly._203;

import java.util.Arrays;

/**
 * @Description: 5496. 你可以获得的最大硬币数目
 * 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
 * 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
 * Alice 将会取走硬币数量最多的那一堆。
 * 你将会取走硬币数量第二多的那一堆。
 * Bob 将会取走最后一堆。
 * 重复这个过程，直到没有更多硬币。
 * 给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
 * <p>
 * 返回你可以获得的最大硬币数目。
 * @Author: matreeix
 * @Date: 2020/8/23
 */

public class Solution2 {

    public static int maxCoins(int[] piles) {
        int cnt = piles.length / 3;
        Arrays.sort(piles);
        int res = 0;
        for (int i = piles.length - 2; cnt > 0; i -= 2) {
            res += piles[i];
            cnt--;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        System.out.println(maxCoins(arr));
    }
}
