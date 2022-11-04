import java.util.ArrayList;
import java.util.List;

class Solution {
    String number;
    int n;
    List<List<Integer>> list;

    public boolean isAdditiveNumber(String num) {
        number = num;
        n = num.length();
        list = new ArrayList<>();
        return backtrack(0);
    }

    private boolean backtrack(int index) {
        if (index == n) {
            return list.size() >= 3;
        }
        int max = number.charAt(index) == '0' ? index + 1 : n;
        List<Integer> cur = new ArrayList<>();
        for (int i = index; i < max; i++) {
            cur.add(0, number.charAt(i) - '0');
            if (list.size() < 2) {
                list.add(cur);
                if (backtrack(i + 1)) {
                    return true;
                }
                list.remove(list.size() - 1);
            } else {
                int cmp = cmp(list.get(list.size() - 2), list.get(list.size() - 1), cur);
                if (cmp == -1) {
                    return false;
                } else if (cmp == 0) {
                    list.add(cur);
                    if (backtrack(i + 1)) {
                        return true;
                    }
                    list.remove(list.size() - 1);
                }
            }
        }
        return false;
    }

    private int cmp(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> sum = new ArrayList<>();
        int i = 0;
        int cur = 0;
        while (i < a.size() || i < b.size()) {
            if (i < a.size()) {
                cur += a.get(i);
            }
            if (i < b.size()) {
                cur += b.get(i);
            }
            sum.add(cur % 10);
            cur /= 10;
            i++;
        }
        if (cur > 0) {
            sum.add(cur);
        }
        if (sum.size() > c.size()) {
            return 1;
        }
        if (sum.size() < c.size()) {
            return -1;
        }
        for (int j = 0; j < sum.size(); j++) {
            if (sum.get(j) > c.get(j)) {
                return 1;
            } else if (sum.get(j) < c.get(j)) {
                return -1;
            }
        }
        return 0;
    }
}
