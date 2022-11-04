class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] > n - mid) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return n - l;
    }
}
