import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean res = !map.containsKey(val);
        if (res) {
            map.put(val, new HashSet<>());
        }
        list.add(val);
        map.get(val).add(list.size() - 1);
        return res;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val).iterator().next();
        if (map.get(val).size() == 1) {
            map.remove(val);
        } else {
            map.get(val).remove(index);
        }
        if (index != list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            map.get(lastVal).remove(list.size() - 1);
            map.get(lastVal).add(index);
        }
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
