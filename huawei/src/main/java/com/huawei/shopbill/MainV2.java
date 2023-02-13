package com.huawei.shopbill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainV2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int m = Integer.parseInt(line.split(" ")[0]);
        int N = Integer.parseInt(line.split(" ")[1]);

        List<Goods> goods = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = sc.nextLine();
            goods.add(new Goods(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1]) , Integer.parseInt(line.split(" ")[2])));
        }


        List<Goods> primaryGoods = new ArrayList<>();

        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).primaryCode != 0) {
                goods.get(goods.get(i).primaryCode-1).accessory.add(goods.get(i));
            } else {
                primaryGoods.add(goods.get(i));
            }
        }

        int[][] dp = new int[primaryGoods.size() + 1][m + 1];

        for (int i = 1; i <= primaryGoods.size(); i++) {
            for (int j = 0; j <= m; j += 10) {

                if (j >= primaryGoods.get(i - 1).price) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - primaryGoods.get(i - 1).price] + primaryGoods.get(i - 1).price * primaryGoods.get(i - 1).satisfaction);

                    if (primaryGoods.get(i - 1).accessory.size() == 1 && j >= primaryGoods.get(i - 1).price + primaryGoods.get(i - 1).accessory.get(0).price) {
                        int max = Math.max(dp[i - 1][j], dp[i - 1][j - primaryGoods.get(i - 1).price]
                                + primaryGoods.get(i - 1).price * primaryGoods.get(i - 1).satisfaction
                                + primaryGoods.get(i - 1).accessory.get(0).price * primaryGoods.get(i - 1).accessory.get(0).satisfaction);
                        dp[i][j] = Math.max(dp[i][j], max);
                    }

                    if (primaryGoods.get(i - 1).accessory.size() == 2 && j >= primaryGoods.get(i - 1).price + primaryGoods.get(i - 1).accessory.get(0).price) {
                        int max = Math.max(dp[i - 1][j], dp[i - 1][j - (primaryGoods.get(i - 1).price + primaryGoods.get(i - 1).accessory.get(0).price)]
                                + primaryGoods.get(i - 1).price * primaryGoods.get(i - 1).satisfaction)
                                + primaryGoods.get(i - 1).accessory.get(0).price * primaryGoods.get(i - 1).accessory.get(0).satisfaction;
                        dp[i][j] = Math.max(dp[i][j], max);
                    }

                    if (primaryGoods.get(i - 1).accessory.size() == 2 && j >= primaryGoods.get(i - 1).price + primaryGoods.get(i - 1).accessory.get(1).price) {
                        int max = Math.max(dp[i - 1][j], dp[i - 1][j - (primaryGoods.get(i - 1).price + primaryGoods.get(i - 1).accessory.get(1).price)]
                                + primaryGoods.get(i - 1).price * primaryGoods.get(i - 1).satisfaction
                                + primaryGoods.get(i - 1).accessory.get(1).price * primaryGoods.get(i - 1).accessory.get(1).satisfaction);
                        dp[i][j] = Math.max(dp[i][j], max);
                    }

                    if (primaryGoods.get(i - 1).accessory.size() == 2 && j >= primaryGoods.get(i - 1).price + primaryGoods.get(i - 1).accessory.get(0).price + primaryGoods.get(i - 1).accessory.get(1).price) {
                        int max = Math.max(dp[i - 1][j], dp[i - 1][j - (primaryGoods.get(i - 1).price + primaryGoods.get(i - 1).accessory.get(0).price + primaryGoods.get(i - 1).accessory.get(1).price)]
                                + primaryGoods.get(i - 1).price * primaryGoods.get(i - 1).satisfaction
                                + primaryGoods.get(i - 1).accessory.get(0).price * primaryGoods.get(i - 1).accessory.get(0).satisfaction
                                + primaryGoods.get(i - 1).accessory.get(1).price * primaryGoods.get(i - 1).accessory.get(1).satisfaction);
                        dp[i][j] = Math.max(dp[i][j], max);
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }


        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int k = 0; k < dp[i].length; k+= 10) {
                if (dp[i][k] > max) {
                    max = dp[i][k];
                }
            }
        }

        System.out.println(max);
    }


    public static class Goods {
        private int num;
        private int price;
        private int satisfaction;
        private int primaryCode;

        public List<Goods> accessory = new ArrayList<>(2);

        public Goods(int price, int satisfaction, int primaryCode) {
            this.num = num;
            this.price = price;
            this.satisfaction = satisfaction;
            this.primaryCode = primaryCode;
        }
    }
}
