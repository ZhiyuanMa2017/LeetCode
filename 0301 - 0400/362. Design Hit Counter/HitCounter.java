class HitCounter {
    int[] buffer;
    int last;
    int sum;

    public HitCounter() {
        buffer = new int[300];
        last = 1;
        sum = 0;
    }

    public void hit(int timestamp) {
        clean(timestamp);
        buffer[timestamp % 300]++;
        sum++;
    }

    public int getHits(int timestamp) {
        clean(timestamp);
        return sum;
    }


    private void clean(int timestamp) {
        if (timestamp == last) {
            return;
        }
        int gap = Math.min(timestamp - last, 300);
        for (int i = 0; i < gap; i++) {
            sum -= buffer[(last + i + 1) % 300];
            buffer[(last + i + 1) % 300] = 0;
        }
        last = timestamp;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
