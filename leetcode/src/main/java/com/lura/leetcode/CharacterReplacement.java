package com.lura.leetcode;

public class CharacterReplacement {

    private int[] map = new int[26];

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();

        int left = 0, right = 0;
        int maxWindows = 0;
        for (; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            maxWindows = Math.max(maxWindows, map[index]);
            if (right - left + 1 > maxWindows + k) {
                index = chars[left] - 'A';
                map[index]--;
                left++;
            }
        }
        return right - left + 1;
    }
}
