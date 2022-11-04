import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cur = i + 1;
            if (cur % 3 == 0 && cur % 5 == 0) {
                res.add("FizzBuzz");
            } else if (cur % 3 == 0) {
                res.add("Fizz");
            } else if (cur % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(cur));
            }
        }
        return res;
    }
}
