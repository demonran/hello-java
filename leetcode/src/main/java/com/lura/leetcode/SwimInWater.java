package com.lura.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SwimInWater {

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{index - n, index, Math.max(grid[i - 1][j], grid[i][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{index, index - 1, Math.max(grid[i][j - 1], grid[i][j])});
                }
            }
        }

        edges.sort(Comparator.comparingInt(edge -> edge[2]));
        UnionFind uf = new UnionFind(m * n);
        int t = 0;
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
            if (uf.connected(0, m * n - 1)) {
                t = edge[2];
                break;
            }
        }
        return t;
    }

    public static class UnionFind {
        private int count;
        private final int[] parent;

        public UnionFind(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
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

        public boolean union(int x, int y) {
            int findX = find(x);
            int findY = find(y);
            if (findX == findY) {
                return true;
            }
            parent[findX] = findY;
            count--;
            return false;
        }

        public boolean connected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }
    }
}
