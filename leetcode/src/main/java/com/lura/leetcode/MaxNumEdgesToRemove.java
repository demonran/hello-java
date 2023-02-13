package com.lura.leetcode;

public class MaxNumEdgesToRemove {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind unionFindAlice = new UnionFind(n);
        UnionFind unionFindBlob = new UnionFind(n);

        int abs = 0;

        for (int[] edge : edges) {
            edge[1]--;
            edge[2]--;
        }

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (unionFindAlice.union(edge[1], edge[2])) {
                    abs++;
                } else {
                    unionFindBlob.union(edge[1], edge[2]);
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (unionFindAlice.union(edge[1], edge[2])) {
                    abs++;
                }
            } else if (edge[0] == 2) {
                if (unionFindBlob.union(edge[1], edge[2])) {
                    abs++;
                }
            }
        }

        if (unionFindAlice.count != 1 || unionFindBlob.count != 1) {
            return -1;
        }

        return abs;
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
    }
}
