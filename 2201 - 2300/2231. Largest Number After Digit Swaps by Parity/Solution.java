import java.util.PriorityQueue;

class Solution {
    public int largestInteger(int num) {
        String s = String.valueOf(num);
        PriorityQueue<Integer> pqe = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqo = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            if (cur % 2 == 0) {
                pqe.offer(cur);
            } else {
                pqo.offer(cur);
            }
        }
        int[] chars = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            if (cur % 2 == 0) {
                chars[i] = pqe.poll();
            } else {
                chars[i] = pqo.poll();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int aChar : chars) {
            stringBuilder.append(aChar);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
