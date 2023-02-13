package com.lura.leetcode;

import java.util.Arrays;

public class NumSimilarGroups {

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uf.isConnected(i, j)) {
                    continue;
                }
                if (isSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                    System.out.println(i + "," + j);
                }
            }
        }
        return uf.countSet;

    }

    private boolean isSimilar(String a, String b) {
        int n = a.length();
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
            }
        }
        return num == 0 || num == 2;
    }

    public static class UnionFind {
        int[] parent;
        int countSet;

        public UnionFind(int n) {
            parent = new int[n];
            countSet = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
                parent[x] = parent[parent[x]];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            countSet--;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
