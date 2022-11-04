import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int i = 1;
        int index = 0;
        while (index < target.length) {
            if (i == target[index]) {
                res.add("Push");
                i++;
                index++;
            } else {
                res.add("Push");
                res.add("Pop");
                i++;
            }
        }
        return res;
    }
}
