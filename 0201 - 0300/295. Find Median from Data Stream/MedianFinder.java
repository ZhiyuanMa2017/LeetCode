import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    private Queue<Integer> maxQueue;
    private Queue<Integer> minQueue;

    MedianFinder() {
        maxQueue = new PriorityQueue<>();
        minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        minQueue.add(num);
        maxQueue.add(-minQueue.poll());
        if (minQueue.size() < maxQueue.size()) {
            minQueue.add(-maxQueue.poll());
        }
    }

    public double findMedian() {
        return minQueue.size() > maxQueue.size()
                ? minQueue.peek() : (minQueue.peek() - maxQueue.peek()) / 2.0;
    }
}
