import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FreqStack {
    List<List<Integer>> l;
    Map<Integer, Integer> freq;

    public FreqStack() {
        l = new ArrayList<>();
        freq = new HashMap<>();
    }

    public void push(int val) {
        int frequency = freq.getOrDefault(val, 0) + 1;
        freq.put(val, frequency);
        if (l.size() < frequency) {
            l.add(new ArrayList<>());
        }
        l.get(frequency - 1).add(val);
    }

    public int pop() {
        List<Integer> max = l.get(l.size() - 1);
        int val = max.get(max.size() - 1);
        max.remove(max.size() - 1);
        freq.put(val, freq.get(val) - 1);
        if (max.size() == 0) {
            l.remove(l.size() - 1);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
