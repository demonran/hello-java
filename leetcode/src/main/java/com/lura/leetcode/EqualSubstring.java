package com.lura.leetcode;

public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int left = 0, right = 0;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            cost += Math.abs(s.charAt(i) - t.charAt(i));
            if (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            right++;
        }
        return  right - left;
    }
}
