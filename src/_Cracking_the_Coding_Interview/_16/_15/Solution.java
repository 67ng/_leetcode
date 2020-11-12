package _Cracking_the_Coding_Interview._16._15;

import java.util.Arrays;

/**
 * @Description: 面试题 16.15. 珠玑妙算
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。
 * 要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * <p>
 * 提示：
 * <p>
 * 1.len(solution) = len(guess) = 4
 * 2.solution和guess仅包含"R","G","B","Y"这4种字符
 * @Author: matreeix
 * @Date: 2020/11/12
 */

public class Solution {
    private static int[] aa = new int[4];
    private static int[] bb = new int[4];
    private static String s = "RGYB";

    public static int[] masterMind(String solution, String guess) {
        int a = 0, b = 0;
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                aa[s.indexOf(solution.charAt(i))]++;
                bb[s.indexOf(guess.charAt(i))]++;
            }
        }
        System.out.println(Arrays.toString(aa));
        System.out.println(Arrays.toString(bb));
        for (int i = 0; i < 4; i++)
            b += Math.min(aa[i], bb[i]);
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(masterMind("BRBB","RBGY")));
    }
}
