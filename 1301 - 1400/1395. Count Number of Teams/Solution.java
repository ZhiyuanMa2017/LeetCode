class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        for (int j = 1; j < n - 1; j++) {
            int iLess = 0;
            int iGreater = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    iLess++;
                } else if (rating[i] > rating[j]) {
                    iGreater++;
                }
            }
            int kLess = 0;
            int kGreater = 0;
            for (int k = j + 1; k < n; k++) {
                if (rating[j] < rating[k]) {
                    kGreater++;
                } else if (rating[j] > rating[k]) {
                    kLess++;
                }
            }
            res += iLess * kGreater + iGreater * kLess;
        }
        return res;
    }
}
