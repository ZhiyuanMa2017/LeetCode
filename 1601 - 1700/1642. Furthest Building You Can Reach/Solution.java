import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> largestJumps = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                largestJumps.add(diff);
            }
            if (largestJumps.size() > ladders) {
                bricks -= largestJumps.poll();
                if (bricks < 0) {
                    return i;
                }
            }
        }
        return heights.length - 1;
    }
}
