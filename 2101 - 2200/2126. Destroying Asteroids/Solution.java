import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long cur = mass;
        for (int asteroid : asteroids) {
            if (cur >= asteroid) {
                cur += asteroid;
            } else {
                return false;
            }
        }
        return true;
    }
}
