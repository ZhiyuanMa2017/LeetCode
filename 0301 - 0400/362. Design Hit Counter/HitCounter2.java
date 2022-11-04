import java.util.TreeMap;

class HitCounter {
    int count;
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public HitCounter() {
        count = 0;
    }

    public void hit(int timestamp) {
        count++;
        map.put(timestamp, count);
    }

    public int getHits(int timestamp) {
        int start = timestamp - 300;
        Integer lastKey = map.floorKey(timestamp);
        if (lastKey == null || lastKey <= start) {
            return 0;
        }
        Integer startKey = map.floorKey(start);
        if (startKey == null) {
            return map.get(lastKey);
        } else {
            return map.get(lastKey) - map.get(startKey);
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
