import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> res = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                res.add(asteroid);
            } else {
                while (!res.isEmpty() && res.peekLast() > 0 && res.peekLast() < -asteroid) {
                    res.pollLast();
                }
                if (!res.isEmpty() && res.peekLast() == -asteroid) {
                    res.pollLast();
                } else if (res.isEmpty() || res.getLast() < 0) {
                    res.add(asteroid);
                }
            }
        }
        int size = res.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = res.pollFirst();
        }
        return result;
    }
}
