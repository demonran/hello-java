package com.lura.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxNumEdgesToRemoveTest {

    private MaxNumEdgesToRemove maxNumEdgesToRemove;

    @BeforeEach
    void setUp() {
        maxNumEdgesToRemove = new MaxNumEdgesToRemove();
    }

    @Test
    void should_remove_2_giving_4_point() {
        int n = 4;
        int[][] edges= new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};

        int count = maxNumEdgesToRemove.maxNumEdgesToRemove(4, edges);

        assertEquals(2, count);
    }
}