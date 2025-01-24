package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // This stores the point's squared values in decreasing order.
        // This is actually achieved via the comparator - which holds the
        // squares difference of the second point with the first point.
        Queue<int[]> maxHeap = new PriorityQueue<>(
                (p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));

        for (int[] p : points) {
            maxHeap.offer(p);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.toArray(new int[k][]);
    }
}
// @lc code=end
