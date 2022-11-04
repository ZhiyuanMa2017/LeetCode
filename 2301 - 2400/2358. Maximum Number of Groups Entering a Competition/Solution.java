class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int res = 0;
        int count = 1;
        int cur = 0;
        while (cur + count < n) {
            res++;
            cur += count;
            count++;
        }
        return res;
    }
}
