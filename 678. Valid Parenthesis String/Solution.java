import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkValidString(String s) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < s.length(); i++) {
            Set<Integer> temp = new HashSet<>();
            if (s.charAt(i) == '(') {
                for (Integer score : set) {
                    score += 1;
                    temp.add(score);
                }
            } else if (s.charAt(i) == ')') {
                for (Integer score : set) {
                    score -= 1;
                    if (score >= 0) {
                        temp.add(score);
                    }
                }
            } else if (s.charAt(i) == '*') {
                for (Integer score : set) {
                    int plus = score + 1;
                    int minus = score - 1;
                    temp.add(score);
                    temp.add(plus);
                    if (minus >= 0) {
                        temp.add(minus);
                    }
                }
            }
            set = temp;
        }
        return set.contains(0);
    }
}
