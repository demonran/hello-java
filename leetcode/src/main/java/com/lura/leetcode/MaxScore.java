package com.lura.leetcode;

public class MaxScore {
    public static int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[n - k + i];
        }
        int maxPoint = sum;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i] - cardPoints[n - k + i];
            maxPoint = Math.max(maxPoint, sum);
        }
        return maxPoint;

    }
}
