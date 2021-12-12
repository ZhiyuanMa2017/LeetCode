class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0;
        int j = plants.length - 1;
        int res = 0;
        int curA = capacityA;
        int curB = capacityB;
        while (i < j) {
            if (curA < plants[i]) {
                curA = capacityA;
                res++;
            }
            if (curB < plants[j]) {
                curB = capacityB;
                res++;
            }
            curA -= plants[i];
            i++;
            curB -= plants[j];
            j--;
        }
        if (i == j) {
            if (curA >= curB) {
                if (curA < plants[i]) {
                    res++;
                }
            } else {
                if (curB < plants[i]) {
                    res++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minimumRefill(new int[]{2, 1, 1}, 2, 2);
    }
}
