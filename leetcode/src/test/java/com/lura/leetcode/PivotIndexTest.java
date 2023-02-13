package com.lura.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PivotIndexTest {

    private PivotIndex pivotIndex;

    @BeforeEach
    void setUp() {
        pivotIndex = new PivotIndex();
    }

    @Test
    void should_return_3_giving_a_nums() {
        int[] nums = new int[]{-1,-1,0,1,1,0};
        int index = pivotIndex.pivotIndex(nums);

        assertEquals(3, index);
    }
}