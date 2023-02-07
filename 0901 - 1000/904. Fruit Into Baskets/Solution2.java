class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int res = 0;
        int[] bucket = new int[n + 1];
        int type = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            bucket[fruits[right]]++;
            if (bucket[fruits[right]] == 1) {
                type++;
            }
            while (type > 2) {
                bucket[fruits[left]]--;
                if (bucket[fruits[left]] == 0) {
                    type--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
