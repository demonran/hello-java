package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class APlusBV8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }
        sc.close();

        lines.forEach(line -> {

            String result = Arrays.stream(line.split(" ")).sorted(Comparator.naturalOrder())
                                 .collect(Collectors.joining(" "));

            System.out.println(result);
        });

    }
}
