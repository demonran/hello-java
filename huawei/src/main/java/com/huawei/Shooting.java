package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

/*
13
3,3,7,4,4,4,4,7,7,3,5,5,5
53,80,68,24,39,76,66,16,100,55,53,80,55
 */
public class Shooting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> count = toInt(sc.nextLine());
        List<Integer> scores = toInt(sc.nextLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> playerScore = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> score = map.getOrDefault(count.get(i), new ArrayList<>());
            score.add(scores.get(i));
            map.put(count.get(i), score);
        }

        map.forEach((player, score) -> {
            if (score.size() >= 3) {
                playerScore.put(player, score.stream().sorted((o1, o2) -> o2 - o1).mapToInt(Integer::intValue).limit(3).sum());
            }
        });

        new ArrayList<>(playerScore.entrySet()).stream()
                                               .sorted((o1, o2) -> {
                                                   if (Objects.equals(o1.getValue(), o2.getValue())) {
                                                       return o2.getKey() - o1.getKey();
                                                   }
                                                   return o2.getValue() - o1.getValue();
                                               })
                                               .map(Map.Entry::getKey)
                                               .forEach(System.out::println);


    }

    private static List<Integer> toInt(String str) {
        return Arrays.stream(str.split(","))
                     .map(Integer::valueOf)
                     .collect(Collectors.toList());

    }
}
