class Solution {
    int res;
    int[] arr;

    public int distributeCookies(int[] cookies, int k) {
        arr = new int[k];
        res = Integer.MAX_VALUE;
        dfs(cookies, 0);
        return res;
    }

    private void dfs(int[] cookies, int index) {
        if (index == cookies.length) {
            int max = 0;
            for (int i : arr) {
                max = Math.max(max, i);
            }
            res = Math.min(res, max);
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j] += cookies[index];
            dfs(cookies, index + 1);
            arr[j] -= cookies[index];
        }
    }
}
