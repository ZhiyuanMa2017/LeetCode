class Solution {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            if (check(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(int n) {
        String s = String.valueOf(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i) - '0';
        }
        return res % 2 == 0;
    }
}
