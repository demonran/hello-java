package com.lura.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualSubstringTest {

    @Test
    void should_return_correct_result() {

        EqualSubstring equalSubstring = new EqualSubstring();

        int count = equalSubstring.equalSubstring("krrgw", "zjxss", 19);

        assertEquals(2, count);
    }

}