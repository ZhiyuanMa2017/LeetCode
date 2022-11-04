public class Solution20210412 {
    public int[] constructArray(int n, int k) {
        int l = 1;
        int h = n;
        int[] res = new int[n];
        int index = 0;
        while (l <= h) {
            if (k > 1) {
                if (k % 2 != 0) {
                    res[index] = l;
                    index++;
                    l++;
                } else {
                    res[index] = h;
                    index++;
                    h--;
                }
                k--;
            } else {
                res[index] = l;
                index++;
                l++;
            }
        }
        return res;
    }
}
