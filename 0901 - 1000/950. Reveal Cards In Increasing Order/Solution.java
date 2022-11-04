import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> deque = new LinkedList<>();
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            deque.add(i);
        }
        Arrays.sort(deck);
        int[] res = new int[n];
        for (int d : deck) {
            res[deque.poll()] = d;
            if (!deque.isEmpty()) {
                deque.offer(deque.poll());
            }
        }
        return res;
    }
}
