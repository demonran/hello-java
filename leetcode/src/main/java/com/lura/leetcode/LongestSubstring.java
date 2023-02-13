package com.lura.leetcode;

public class LongestSubstring {
    public static int longestSubstring(String s, int k) {
        int[] arr = new int[26];

        int n = s.length();
        for (int i = 0; i <n ; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int maxWindows = 0;
        int left = 0;
        for (int right = 0; right <n ; right++) {
            if (arr[s.charAt(right) - 'a'] < k) {
                maxWindows = Math.max(right - left, maxWindows);
                left = right + 1;
            }
        }
        return Math.max(n - left, maxWindows);
    }
}
