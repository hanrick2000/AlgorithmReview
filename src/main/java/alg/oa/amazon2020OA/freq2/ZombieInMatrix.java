package alg.oa.amazon2020OA.freq2;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/*
related leetcode 994 : rotting oranges
space O(r * c)
time O(r * c)
 */
public class ZombieInMatrix {
    private static final int ZOMBIE = 1;
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minHours(List<List<Integer>> grid) {
        int people = 0;
        Queue<Point> zombies = new ArrayDeque<>();
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.get(0).size(); c++) {
                if (grid.get(r).get(c) == ZOMBIE) {
                    zombies.add(new Point(r, c));
                } else {
                    people++;
                }
            }
        }

        if (people == 0) return 0;

        for (int hours = 1; !zombies.isEmpty(); hours++) {
            for (int sz = zombies.size(); sz > 0; sz--) {
                Point zombie = zombies.poll();

                for (int[] dir : DIRS) {
                    int r = zombie.r + dir[0];
                    int c = zombie.c + dir[1];

                    if (isHuman(grid, r, c)) {
                        people--;
                        if (people == 0) return hours;
                        grid.get(r).set(c, ZOMBIE);
                        zombies.add(new Point(r, c));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isHuman(List<List<Integer>> grid, int r, int c) {
        return r >= 0 && r < grid.size() && c >= 0 && c < grid.get(0).size() && grid.get(r).get(c) != ZOMBIE;
    }

    private static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
