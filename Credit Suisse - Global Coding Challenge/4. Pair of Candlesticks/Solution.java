class Solution {

    static int totalPairs(int n, int[] values) {
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (values[i] < values[i + 1]) {
                res++;
            } else {
                int twoMin = Math.min(values[i], values[i + 1]);
                for (int j = i + 1; j < n; j++) {
                    if (values[j] >= twoMin) {
                        res++;
                        if (values[j] >= values[i]) {
                            break;
                        }
                        twoMin = Math.min(values[i], values[j]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] values = new int[]{10, 2, 8, 12, 16};
        System.out.println(totalPairs(n, values));
    }
}
