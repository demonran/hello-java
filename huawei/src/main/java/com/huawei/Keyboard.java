package com.huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Keyboard {
    public static void main(String[] args) {
        List<Integer> keys =
                Arrays.stream(new Scanner(System.in).nextLine().split(" ")).map(Integer::valueOf).collect(toList());

        String words = "";
        String clipboard = "";
        String selected = "";

        for (Integer key : keys) {
            switch (key) {
                case 1:
                    words = words.replace(selected, "");
                    words += "A";
                    selected = "";
                    break;
                case 2:
                    clipboard = selected;
                    break;
                case 3:
                    words = words.replace(selected, "");
                    clipboard = selected;
                    selected = "";
                    break;
                case 4:
                    words = words.replace(selected, "");
                    words += clipboard;
                    selected = "";
                    break;
                case 5:
                    selected = words;
                    break;
                default:


            }
        }

        System.out.println(words.length());
    }
}
