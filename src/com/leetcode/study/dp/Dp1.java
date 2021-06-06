package com.leetcode.study.dp;

/**
 * 背包问题
 * 钞票面值: 1, 5, 11
 */
public class Dp1 {

    /**
     * 组成某个金额的钞票最少张数
     * @param w 金额
     */
    public static void solution1(int w) {
        int[] f = new int[1000];
        f[0] = 0;
        for (int i = 1; i <= w; i++) {
            int cost = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                cost = Math.min(cost, f[i - 1] + 1);
            }
            if (i - 5 >= 0) {
                cost = Math.min(cost, f[i - 5] + 1);
            }
            if (i - 11 >= 0) {
                cost = Math.min(cost, f[i - 11] + 1);
            }
            f[i] = cost;
            System.out.println("F[" + i + "]=" + f[i]);
        }

    }

    public static void main(String[] args) {
        solution1(15);
    }
}
