class Solution {
    public boolean isPowerOfThree(int n) {
        int power = (int) Math.floor(Math.log(Integer.MAX_VALUE) / Math.log(3));
        int maxPowerOf3 = (int) Math.pow(3, power);
        return n > 0 && maxPowerOf3 % n == 0;
    }
}
