import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minimumScore(String s, String t) {
        int n = s.length();
        int m = t.length();
        List<int[]> a = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                a.add(new int[]{j, i});
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (a.size() == m) {
            return 0;
        }
        List<int[]> b = new ArrayList<>();
        i = n - 1;
        j = m - 1;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == t.charAt(j)) {
                b.add(new int[]{j, i});
                i--;
                j--;
            } else {
                i--;
            }
        }
        if (a.isEmpty() && b.isEmpty()) {
            return t.length();
        }
        Collections.reverse(b);
        i = 0;
        j = 0;
        int res = m;
        while (i < a.size()) {
            int[] cur = a.get(i);
            while (j < b.size() && b.get(j)[1] <= cur[1]) {
                j++;
            }
            if (j == b.size()) {
                res = Math.min(res, m - 1 - a.get(i)[0]);
            } else {
                res = Math.min(res, b.get(j)[0] - a.get(i)[0] - 1);
            }
            i++;
        }
        i = a.size() - 1;
        j = b.size() - 1;
        while (j >= 0) {
            while (i >= 0 && a.get(i)[1] >= b.get(j)[1]) {
                i--;
            }
            if (i == -1) {
                res = Math.min(res, b.get(j)[0]);
            } else {
                res = Math.min(res, b.get(j)[0] - a.get(i)[0] - 1);
            }
            j--;
        }
        return res;
    }
}
