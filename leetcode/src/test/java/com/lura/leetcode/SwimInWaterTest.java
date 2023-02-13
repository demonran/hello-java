package com.lura.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwimInWaterTest {

    private SwimInWater swimInWater;

    @BeforeEach
    void setUp() {
        swimInWater = new SwimInWater();
    }

    @Test
    void should_return_3_giving_a_grid() {
        int[][] grid = {{0,2},{1,3}};

        int t = swimInWater.swimInWater(grid);

        assertEquals(3, t);
    }

    @Test
    void should_return_16_giving_a_grid() {
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};

        int t = swimInWater.swimInWater(grid);

        assertEquals(16, t);
    }
}