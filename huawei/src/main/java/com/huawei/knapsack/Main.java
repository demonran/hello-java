package com.huawei.knapsack;

public class Main {

    public static void main(String[] args) {

        int N = 4;
        int j = 8;

        int[][] goods = {{2, 3}, {3, 4}, {4, 5}, {5, 6}};

        int[][] dp = new int[N + 1][j + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int k = 0; k < j + 1; k++) {

                if (k >= goods[i - 1][0]) {
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - goods[i - 1][0]] + goods[i - 1][1]);
                } else {
                    dp[i][k] = dp[i - 1][k];
                }

            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int k = 0; k < dp[i].length; k++) {
                System.out.println(i + "," + k + "=" + dp[i][k]);
                if (dp[i][k] > max) {
                    max = dp[i][k];
                }
            }
        }


        System.out.println(max);

    }
}
