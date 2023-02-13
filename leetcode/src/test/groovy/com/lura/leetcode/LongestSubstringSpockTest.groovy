package com.lura.leetcode

import spock.lang.Specification

class LongestSubstringSpockTest extends Specification{

    def "should return correct"() {
        expect:
            LongestSubstring.longestSubstring(s, k) == result
        where:
            s | k | result
            "aaabb" | 3 | 3
            "ababbc" | 2 | 5
            "ababacb" |3 | 0

    }
}
