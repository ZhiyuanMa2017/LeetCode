class Solution {
    public int partitionString(String s) {
        int set = 0;
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            if (((set >> num) & 1) != 0) {
                set = 0;
                res++;
            }
            set |= 1 << num;
        }
        return res;
    }
}
