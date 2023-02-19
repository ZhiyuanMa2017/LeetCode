class Solution {
    public int minOperations(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                if (count > 1) {
                    res++;
                    count = 1;
                } else if (count == 1) {
                    res++;
                    count = 0;
                }
            }
        }
        if (count > 1) {
            res += 2;
        } else if (count == 1) {
            res += 1;
        }
        return res;
    }
}
