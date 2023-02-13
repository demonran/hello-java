package com.lura.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxScoreTest {

    @Test
    void should_return_correct_result() {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int maxPoint = MaxScore.maxScore(cardPoints, 3);
        assertEquals(12, maxPoint);
    }

}