import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FreqStack {
    List<List<Integer>> list;
    Map<Integer, Integer> valToFreq;

    public FreqStack() {
        list = new ArrayList<>();
        valToFreq = new HashMap<>();
    }

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        if (list.size() < freq) {
            list.add(new ArrayList<>());
        }
        list.get(freq - 1).add(val);
    }

    public int pop() {
        List<Integer> max = list.get(list.size() - 1);
        int val = max.get(max.size() - 1);
        int freq = valToFreq.get(val);
        if (freq == 1) {
            valToFreq.remove(val);
        } else {
            valToFreq.put(val, freq - 1);
        }
        max.remove(max.size() - 1);
        if (max.size() == 0) {
            list.remove(list.size() - 1);
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
