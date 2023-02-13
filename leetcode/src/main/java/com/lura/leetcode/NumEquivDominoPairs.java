package com.lura.leetcode;

public class NumEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < dominoes.length - 1; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) {
                    count++;
                } else if (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numEquivDominoPairsFromOfficial(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }

}
