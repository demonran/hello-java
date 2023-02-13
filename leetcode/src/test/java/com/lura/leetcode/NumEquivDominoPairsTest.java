package com.lura.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumEquivDominoPairsTest {

    private NumEquivDominoPairs numEquivDominoPairs;

    @BeforeEach
    void setUp() {
        numEquivDominoPairs = new NumEquivDominoPairs();
    }

    @Test
    void should_return_1_giving_a_dominoes() {
        int[][] dominoes =  new int[][]{{1,2},{2,1},{3,4},{5,6}};

        int count = numEquivDominoPairs.numEquivDominoPairs(dominoes);

        assertEquals(1, count);
    }

    @Test
    void should_return_2_giving_a_dominoes() {
        int[][] dominoes =  new int[][]{{1,2},{2,1},{3,4},{3,4}};

        int count = numEquivDominoPairs.numEquivDominoPairs(dominoes);

        assertEquals(2, count);
    }

    @Test
    void should_return_0_giving_a_dominoes() {
        int[][] dominoes =  new int[][]{{1,2}};

        int count = numEquivDominoPairs.numEquivDominoPairs(dominoes);

        assertEquals(0, count);
    }

    @Test
    void should_return_0_giving_a_dominoes_zero_array() {
        int[][] dominoes =  new int[0][0];

        int count = numEquivDominoPairs.numEquivDominoPairs(dominoes);

        assertEquals(0, count);
    }

    @Test
    void should_return_3_giving_a_dominoes() {
        int[][] dominoes =  new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}};

        int count = numEquivDominoPairs.numEquivDominoPairs(dominoes);

        assertEquals(3, count);
    }

    @Test
    void should_return_3_giving_a_dominoes_when_call_numEquivDominoPairsFromOfficial() {
        int[][] dominoes =  new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}};

        int count = numEquivDominoPairs.numEquivDominoPairsFromOfficial(dominoes);

        assertEquals(3, count);
    }
}