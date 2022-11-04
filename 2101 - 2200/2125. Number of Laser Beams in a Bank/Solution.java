class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int pre = 0;
        for (int i = 0; i < bank.length; i++) {
            int cur = cal(bank[i]);
            res += pre * cur;
            if (cur != 0) {
                pre = cur;
            }
        }
        return res;
    }

    private int cal(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }
}
