import java.util.ArrayList;
import java.util.List;

class OrderedStream {
    int index;
    String[] strings;

    public OrderedStream(int n) {
        index = 1;
        strings = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        strings[idKey] = value;
        List<String> res = new ArrayList<>();
        while (index < strings.length && strings[index] != null) {
            res.add(strings[index]);
            index++;
        }
        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
