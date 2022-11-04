import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                String partOne = expression.substring(0, i);
                String partTwo = expression.substring(i + 1);
                List<Integer> partOneRes = diffWaysToCompute(partOne);
                List<Integer> partTwoRes = diffWaysToCompute(partTwo);
                int cur = 0;
                for (Integer one : partOneRes) {
                    for (Integer two : partTwoRes) {
                        if (expression.charAt(i) == '+') {
                            cur = one + two;
                        } else if (expression.charAt(i) == '-') {
                            cur = one - two;
                        } else {
                            cur = one * two;
                        }
                        res.add(cur);
                    }
                }

            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
