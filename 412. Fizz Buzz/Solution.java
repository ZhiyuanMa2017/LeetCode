import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int buzz = 0;
        int fizz = 0;
        for (int i = 1; i <= n; i++) {
            buzz++;
            fizz++;
            if (fizz == 3 && buzz == 5) {
                res.add("FizzBuzz");
                buzz = 0;
                fizz = 0;
            } else if (fizz == 3) {
                res.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                res.add("Buzz");
                buzz = 0;
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
