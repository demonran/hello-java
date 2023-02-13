package com.huawei.shopbill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int N = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);

        ShopCart shopCart = new ShopCart(N);
        Shop shop = new Shop();

        for (int i = 0; i < m; i++) {
            String[] goodsProperties = sc.nextLine().split(" ");
            shop.addGoods(new Goods(i + 1, Integer.parseInt(goodsProperties[0]), Integer.parseInt(goodsProperties[1]), Integer.parseInt(goodsProperties[2])));
        }



        List<Goods> sortedGoods = shop.goodsList.stream().sorted(Comparator.comparing(Goods::getCostPerformance).reversed()).collect(Collectors.toList());

        sortedGoods.forEach(goods -> {
            if (goods.isPrimary()) {
                shopCart.buy(Collections.singletonList(goods));
            } else {

            }
        });


    }

    public static class ShopCart {
        private int totalMoney;
        private List<Goods> goodsList = new ArrayList<>();

        public ShopCart(int totalMoney) {
            this.totalMoney = totalMoney;
        }

        public void buy(List<Goods> goods) {
            int goodsTotalPrice = goods.stream().mapToInt(Goods::getPrice).sum();
            if (remainMoney() < goodsTotalPrice) {
                return;
            }
            goodsList.addAll(goods);
        }

        private int remainMoney() {
            return totalMoney - goodsList.stream().mapToInt(Goods::getPrice).sum();
        }

    }

    public static class Shop {
        private List<Goods> goodsList = new LinkedList<>();

        public void addGoods(Goods goods) {

            if (goodsList.isEmpty()) {
                goodsList.add(goods);
            }else {
                for (int i = 0; i < goodsList.size(); i++) {
                    Goods item = goodsList.get(i);
                    if (item.getCostPerformance().compareTo(goods.getCostPerformance()) < 0 && goods.primaryCode != item.num) {
                        goodsList.add(i, goods);
                    }
                }
            }
        }
    }


    public static class Goods {
        private int num;
        private int price;
        private int satisfaction;
        private int primaryCode;

        public Goods(int num, int price, int satisfaction, int primaryCode) {
            this.num = num;
            this.price = price;
            this.satisfaction = satisfaction;
            this.primaryCode = primaryCode;
        }

        public int getPrice() {
            return price;
        }

        public BigDecimal getCostPerformance() {
            return BigDecimal.valueOf(price).divide(BigDecimal.valueOf(satisfaction));
        }

        public boolean isPrimary() {
            return primaryCode == 0;
        }
    }
}
