class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }
}
