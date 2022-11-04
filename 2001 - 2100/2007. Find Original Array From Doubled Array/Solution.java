class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            return new int[]{};
        }
        int[] res = new int[n / 2];
        int[] count = new int[9];
        for (int i : changed) {
            count[i]++;
        }
        int index = 0;
        for (int i = 8; i >= 1; i--) {
            if (count[i] == 0) {
                continue;
            }
            if (i % 2 == 1) {
                return new int[]{};
            }
            if (count[i] > count[i / 2]) {
                return new int[]{};
            }
            for (int j = 0; j < count[i]; j++) {
                res[index] = i / 2;
                index++;
            }
            count[i / 2] -= count[i];
            count[i] = 0;
        }
        if (count[0] % 2 == 1) {
            return new int[]{};
        }
        for (int i = 0; i < count[0] / 2; i++) {
            res[index] = 0;
            index++;
        }
        return res;
    }
}
