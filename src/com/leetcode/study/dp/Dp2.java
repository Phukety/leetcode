package com.leetcode.study.dp;

import java.util.Arrays;

/**
 * 给定长度为n的序列a，从a中抽取出一个子序列，这个子序列需要单调递增。问最长的上升子序列（LIS）的长度。
 * e.g. 1,5,3,4,6,9,7,8 的LIS为 1,3,4,6,7,8，长度为6
 */
public class Dp2 {

    /**
     * 求输入序列的最长上升子序列
     *
     * @param sequences 序列
     */
    public static void solution1(int[] sequences) {
        System.out.println("sequences=" + Arrays.toString(sequences));
        int seqLength = sequences.length;

        int[] f = new int[sequences.length];
        for (int t = 0; t < seqLength; t++) {
            f[t] = 1;
        }

        int maxLength = 0;
        for (int i = 0; i < seqLength; i++) {
            for (int j = 0; j < seqLength - 1; j++) {
                if (sequences[i] > sequences[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        for (int k = 0; k < seqLength; k++) {
            if (maxLength < f[k]) {
                maxLength = f[k];
            }
            System.out.println("f[" + (k + 1) + "]=" + f[k]);
        }
        System.out.println("max=" + maxLength);
    }

    public static void main(String[] args) {
        int[] sequences = new int[]{1, 5, 3, 4, 6, 9, 7, 8};
        solution1(sequences);
    }
}
