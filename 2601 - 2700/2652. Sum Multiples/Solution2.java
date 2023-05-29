class Solution {
    public int sumOfMultiples(int n) {
        return cal(n, 3) + cal(n, 5) + cal(n, 7) - cal(n, 15) - cal(n, 21) - cal(n, 35) + cal(n, 105);
    }

    private int cal(int n, int p) {
        int an = n / p * p;
        int count = n / p;
        return (p + an) * count / 2;
    }
}
