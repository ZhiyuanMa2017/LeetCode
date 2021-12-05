import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            String s = "";
            if (digits[i] % 2 != 0) {
                continue;
            }
            for (int first = 0; first < digits.length; first++) {
                if (digits[first] == 0 || first == i) {
                    continue;
                }
                for (int second = 0; second < digits.length; second++) {
                    if (second == first || second == i) {
                        continue;
                    }
                    s = "" + digits[first] + digits[second] + digits[i];
                    res.add(Integer.parseInt(s));
                }
            }
        }
        List<Integer> temp = new ArrayList<>(res);
        Collections.sort(temp);
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}
