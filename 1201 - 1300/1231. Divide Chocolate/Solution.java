class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int l = 1;
        int r = (int) 1e9 / (k + 1);
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            int cur = 0;
            int cuts = 0;
            for (int i : sweetness) {
                cur += i;
                if (cur >= mid) {
                    cur = 0;
                    cuts++;
                    if (cuts > k) {
                        break;
                    }
                }
            }
            if (cuts > k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
