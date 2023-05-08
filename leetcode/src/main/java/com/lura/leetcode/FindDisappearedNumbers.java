package com.lura.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ret = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            ret.add(i);
        }

        for (int num : nums) {
            ret.remove(Integer.valueOf(num));
        }

        return ret;

    }

}
