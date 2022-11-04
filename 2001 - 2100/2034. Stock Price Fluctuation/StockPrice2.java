import java.util.Map;
import java.util.TreeMap;

class StockPrice {
    int lastTime;
    Map<Integer, Integer> map;
    TreeMap<Integer, Integer> treeMap;

    public StockPrice() {
        lastTime = -1;
        map = new TreeMap<>();
        treeMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        lastTime = Math.max(timestamp, lastTime);
        if (map.containsKey(timestamp)) {
            int oldPrice = map.get(timestamp);
            if (treeMap.get(oldPrice) == 1) {
                treeMap.remove(oldPrice);
            } else {
                treeMap.put(oldPrice, treeMap.get(oldPrice) - 1);
            }
        }
        treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
        map.put(timestamp, price);
    }

    public int current() {
        return map.get(lastTime);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
