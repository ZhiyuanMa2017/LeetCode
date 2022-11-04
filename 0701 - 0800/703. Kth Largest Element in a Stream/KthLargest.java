import java.util.PriorityQueue;

class KthLargest {
    int size;
    PriorityQueue<Integer> priorityQueue;

    public KthLargest(int k, int[] nums) {
        size = k;
        priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        while (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
    }

    public int add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size() > size) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
