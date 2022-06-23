import java.util.PriorityQueue;

class SeatManager {
    PriorityQueue<Integer> pq;
    int count;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        count = 1;
    }

    public int reserve() {
        if (pq.isEmpty()) {
            count++;
            return count - 1;
        } else {
            return pq.poll();
        }
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
