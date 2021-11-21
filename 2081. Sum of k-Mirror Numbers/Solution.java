import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Long> res;
    int base;
    int count;

    public long kMirror(int k, int n) {
        res = new ArrayList<>();
        base = k;
        count = n;
        int len = 1;
        long result = 0;
        while (res.size() < n) {
            char[] num = new char[len];
            backtrack(num, 0);
            len++;
        }
        for (int i = 0; i < res.size(); i++) {
            result += res.get(i);
        }
        return result;
    }

    private void backtrack(char[] num, int start) {
        if (start >= (num.length + 1) / 2) {
            String s = new String(num);
            long number = Long.parseLong(s, base);
            if (check(number)) {
                res.add(number);

            }
        } else {
            for (int i = 0; i < base; i++) {
                if (res.size() == count) {
                    return;
                }
                if (start == 0 && i == 0) {
                    continue;
                }
                num[start] = (char) (i + '0');
                num[num.length - 1 - start] = (char) (i + '0');
                System.out.println(start);
                System.out.println(new String(num));
                backtrack(num, start + 1);
            }
        }
    }

    private boolean check(long number) {
        String s = String.valueOf(number);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.kMirror(3, 7);
    }
}
