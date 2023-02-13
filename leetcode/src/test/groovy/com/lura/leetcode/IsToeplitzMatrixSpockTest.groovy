package com.lura.leetcode

import spock.lang.Specification

class IsToeplitzMatrixSpockTest extends Specification{

    def "should_return_correct"() {
        expect:
            IsToeplitzMatrix.isToeplitzMatrix(matrix as int[][]) == result

        where:
            matrix | result
        [[1,2,3,4],[5,1,2,3],[9,5,1,2]] | true
        [[1,2],[2,2]] | false
    }
}
