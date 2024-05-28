class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int cost = 0;
        int left = 0;
        int res = 0;
        for (int right = 0; right < n; right++) {
            cost += diff[right];
            while (left < right && cost > maxCost) {
                cost -= diff[left];
                left++;
            }
            if (cost <= maxCost) {
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }
}
