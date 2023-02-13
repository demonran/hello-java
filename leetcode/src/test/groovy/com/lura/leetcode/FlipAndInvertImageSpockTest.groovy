package com.lura.leetcode

import spock.lang.Specification

class FlipAndInvertImageSpockTest extends Specification{

    def "should_return_correct"() {
        expect:
            FlipAndInvertImage.flipAndInvertImage(A as int[][]) == result as int[][]

        where:
            A | result
            [[1,1,0],[1,0,1],[0,0,0]] | [[1,0,0],[0,1,0],[1,1,1]]
    }
}
