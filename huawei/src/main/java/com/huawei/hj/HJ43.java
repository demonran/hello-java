package com.huawei.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HJ43 {
    static int[][] maze;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String[] line = sc.nextLine().split(" ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        maze = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                maze[i][j] = Integer.parseInt(line[j]);
            }
        }
        sc.close();
        List<Position> pos = new ArrayList<Position>();
        pos.add(new Position(0, 0));
        walk(0, 0, pos);

    }

    private static void walk(int x, int y, List<Position> pos) {
        if (x + 1 < maze[0].length && maze[y][x + 1] == 0) {
            Position p = new Position(x + 1, y);
            if (!pos.contains(p)) {
                List<Position> newPos = new ArrayList<>(pos);
                newPos.add(p);
                walk(x + 1, y, newPos);
            }
        }
        if (x - 1 >= 0 && maze[y][x - 1] == 0) {
            Position p = new Position(x - 1, y);
            if (!pos.contains(p)) {
                List<Position> newPos = new ArrayList<>(pos);
                newPos.add(p);
                walk(x - 1, y, newPos);
            }
        }

        if (y + 1 < maze.length && maze[y + 1][x] == 0) {
            Position p = new Position(x, y + 1);
            if (!pos.contains(p)) {
                List<Position> newPos = new ArrayList<>(pos);
                newPos.add(p);
                walk(x, y + 1, newPos);
            }
        }

        if (y - 1 >= 0 && maze[y - 1][x] == 0) {
            Position p = new Position(x, y - 1);
            if (!pos.contains(p)) {
                List<Position> newPos = new ArrayList<>(pos);
                newPos.add(p);
                walk(x, y - 1, newPos);
            }
        }

        if (x == maze[0].length - 1 && y == maze.length - 1) {
            pos.forEach(p -> System.out.printf("(%s,%s)%n", p.x, p.y));
        }
    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
