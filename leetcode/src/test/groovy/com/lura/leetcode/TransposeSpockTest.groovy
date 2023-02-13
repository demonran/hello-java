package com.lura.leetcode

import spock.lang.Specification

class TransposeSpockTest extends Specification{

    def "should return correct"() {
        expect:
            Transpose.transpose(matrix as int[][]) == result as int[][]
        where:
            matrix | result
            [[1,2,3],[4,5,6],[7,8,9]] | [[1,4,7],[2,5,8],[3,6,9]]
            [[1,2,3],[4,5,6]] | [[1,4],[2,5],[3,6]]
    }

}