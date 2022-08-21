import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long kSum(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(b.sum, a.sum));
        long res = sum;
        pq.offer(new Node(sum - nums[0], 0));
        for (int i = 2; i <= k; i++) {
            Node cur = pq.poll();
            res = cur.sum;
            int index = cur.index;
            if (index + 1 < nums.length) {
                pq.offer(new Node(res + nums[index] - nums[index + 1], index + 1));
                pq.offer(new Node(res - nums[index + 1], index + 1));
            }
        }
        return res;
    }

    class Node {
        long sum;
        int index;

        Node(long s, int i) {
            sum = s;
            index = i;
        }
    }
}
