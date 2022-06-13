class Solution {
    public int hIndex(int[] citations) {
        int l = 0;
        int h = citations.length;
        while (l < h) {
            int mid = l + (h - l + 1) / 2;
            if (check(citations, mid)) {
                l = mid;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[] citations, int k) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= k) {
                count++;
            }
        }
        return count >= k;
    }
}
