class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            int resI = f(nums[i], a, b, c);
            int resJ = f(nums[j], a, b, c);
            if (a >= 0) {
                if (resI >= resJ) {
                    res[index] = resI;
                    i++;
                } else {
                    res[index] = resJ;
                    j--;
                }
                index--;
            } else {
                if (resI >= resJ) {
                    res[index] = resJ;
                    j--;
                } else {
                    res[index] = resI;
                    i++;
                }
                index++;
            }
        }
        return res;
    }

    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
