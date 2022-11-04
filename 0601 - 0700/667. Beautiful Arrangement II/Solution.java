class Solution {
    public static int[] constructArray(int n, int k) {
        int l = 1;
        int h = n;
        int[] res = new int[n];
        int index = 0;
        while (l <= h) {
            if (k > 1) {
                if (k % 2 != 0) {
                    res[index] = l;
                    l++;
                    index++;
                } else {
                    res[index] = h;
                    h--;
                    index++;
                }
                k--;
            } else {
                res[index] = l;
                l++;
                index++;
            }
        }
        return res;
    }
}
