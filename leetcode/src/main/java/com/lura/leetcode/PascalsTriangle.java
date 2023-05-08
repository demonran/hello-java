package com.lura.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ret.add(i, 0);
            for (int j = i; j > 0; j--) {
                ret.set(j, ret.get(j) + ret.get(j - 1));
            }
        }
        return ret;

    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                } else {
                    current.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = current;
        }
        return pre;

    }
}
