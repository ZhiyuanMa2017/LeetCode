class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int num = n / k;
        if (n % k != 0) {
            num += 1;
        }
        String[] res = new String[num];
        for (int i = 0; i < num; i += 1) {
            if (i * k + k < s.length()) {
                res[i] = s.substring(i * k, i * k + k);
            } else {
                res[i] = s.substring(i * k);
            }
        }
        if (n % k == 0) {
            return res;
        }
        int mod = k - res[num - 1].length();
        StringBuilder last = new StringBuilder(res[num - 1]);
        for (int i = 0; i < mod; i++) {
            last.append(fill);
        }
        res[num - 1] = last.toString();
        return res;
    }
}
