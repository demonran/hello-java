package com.lura.leetcode;

public class RegionsBySlashes {

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;
        UnionFind unionFind = new UnionFind(size);

        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                char c = row[j];
                int index = 4 * (i * N + j);
                if (c == '/') {
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1, index + 2);
                } else if (c == '\\') {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                }else {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1, index + 2);
                    unionFind.union(index + 2, index + 3);
                }

                if (j + 1 < N) {
                    unionFind.union(index + 1, index + 4 + 3);
                }
                if (i + 1 < N) {
                    unionFind.union(index + 2, index + 4 * N);
                }
            }
        }

        return unionFind.count;

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

        public void union(int x, int y) {
            int findX = find(x);
            int findY = find(y);
            if (findX == findY) {
                return;
            }
            parent[findX] = findY;
            count--;
        }
    }

}
