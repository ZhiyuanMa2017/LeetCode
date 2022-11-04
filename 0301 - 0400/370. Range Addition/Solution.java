class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] u : updates) {
            res[u[0]] += u[2];
            if (u[1] + 1 < length) {
                res[u[1] + 1] += -u[2];
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
