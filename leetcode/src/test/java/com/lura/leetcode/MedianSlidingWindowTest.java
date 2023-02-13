package com.lura.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MedianSlidingWindowTest {

    private MedianSlidingWindow medianSlidingWindow;

    @BeforeEach
    void setUp() {

        medianSlidingWindow = new MedianSlidingWindow();
    }

    @Test
    void should_return_right_value_giving_a_nums_and_k() {
        int[] nums = {1,2,3,4};
        int k = 4;

        double[] array = medianSlidingWindow.medianSlidingWindow(nums, k);

        assertArrayEquals(new double[]{2.5}, array);
    }

    @Test
    void test_add() {
        System.out.println( (2147483647L + 2147483647)/2.0);
    }
}