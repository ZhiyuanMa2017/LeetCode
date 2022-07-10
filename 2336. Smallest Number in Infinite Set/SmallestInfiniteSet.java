import java.util.PriorityQueue;

class SmallestInfiniteSet {
    int index;
    PriorityQueue<Integer> pq;

    public SmallestInfiniteSet() {
        index = 1;
        pq = new PriorityQueue<>();
    }

    public int popSmallest() {
        if (pq.isEmpty()) {
            index++;
            return index - 1;
        } else {
            return pq.poll();
        }
    }

    public void addBack(int num) {
        if (!pq.contains(num) && num < index) {
            pq.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
