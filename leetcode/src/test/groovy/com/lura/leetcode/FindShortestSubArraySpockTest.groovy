package com.lura.leetcode

import spock.lang.Specification
import spock.lang.Unroll

class FindShortestSubArraySpockTest extends Specification{

    @Unroll
    def "should find shortest sub array"() {
        expect:
            FindShortestSubArray.findShortestSubArray(nums as int[]) == result

        where:
            nums | result
            [1, 2, 2, 3, 1] | 2
            [1,2,2,3,1,4,2] | 6
    }
}
