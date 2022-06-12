class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int before = 0;
        for (int[] bracket : brackets) {
            int up = bracket[0];
            int rate = bracket[1];
            if (income >= up) {
                res += (double) (up - before) * rate / 100;
                before = up;
            } else {
                res += (double) (income - before) * rate / 100;
                break;
            }
        }
        return res;
    }
}
