package com.lura.leetcode


import spock.lang.Specification
import spock.lang.Unroll

class MaxScoreSpockTest extends Specification {


    @Unroll
    def "should return max score "() {
        expect:
            MaxScore.maxScore(arr as int[], k) == result;
        where:
            arr | k | result
            [1] | 1 | 1
            [1] | 1 | 1

    }

}
