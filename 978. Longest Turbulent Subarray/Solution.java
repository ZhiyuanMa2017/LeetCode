class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int greater = 1;
        int less = 1;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                greater = less + 1;
                less = 1;
            } else if (arr[i] < arr[i - 1]) {
                less = greater + 1;
                greater = 1;
            } else {
                greater = 1;
                less = 1;
            }
            res = Math.max(res, Math.max(greater, less));
        }
        return res;
    }
}
