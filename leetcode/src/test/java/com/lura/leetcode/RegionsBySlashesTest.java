package com.lura.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegionsBySlashesTest {

    private RegionsBySlashes regionsBySlashes;

    @BeforeEach
    void setUp() {
        regionsBySlashes = new RegionsBySlashes();
    }

    @Test
    void should_return_2_giving_a_left_slash() {
        //given
        String[] grid = new String[]{"/"};

        int count = regionsBySlashes.regionsBySlashes(grid);

        assertEquals(2, count);

    }

    @Test
    void should_return_5_giving_a_grid() {
        //given
        String[] grid = new String[]{"/\\","\\/"};

        int count = regionsBySlashes.regionsBySlashes(grid);

        assertEquals(5, count);

    }

    @Test
    void should_return_1_giving_a_grid() {
        //given
        String[] grid = new String[]{"  ","  "};

        int count = regionsBySlashes.regionsBySlashes(grid);

        assertEquals(1, count);

    }
}