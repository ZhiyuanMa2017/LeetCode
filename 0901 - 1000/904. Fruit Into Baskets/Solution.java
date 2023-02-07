class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int res = 0;
        int a = -1;
        int b = -1;
        int countA = 0;
        int countB = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (fruits[right] == a) {
                countA++;
            } else if (fruits[right] == b) {
                countB++;
            } else if (a == -1) {
                a = fruits[right];
                countA++;
            } else if (b == -1) {
                b = fruits[right];
                countB++;
            } else {
                while (countB > 0 && countA > 0) {
                    if (fruits[left] == a) {
                        countA--;
                    } else if (fruits[left] == b) {
                        countB--;
                    }
                    left++;
                }
                if (countA == 0) {
                    a = fruits[right];
                    countA++;
                } else if (countB == 0) {
                    b = fruits[right];
                    countB++;
                }
            }
            res = Math.max(res, countB + countA);
        }
        return res;
    }
}
