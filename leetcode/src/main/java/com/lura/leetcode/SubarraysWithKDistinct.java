package com.lura.leetcode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SubarraysWithKDistinct {

    public int subarraysWithKDistinct(int[] A, int K) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            if (queue.contains(i)) {
                queue.poll();
            }
            queue.add(i);
            if (queue.size() == K) {
                ret++;
            }
        }
        return ret;
    }
}
