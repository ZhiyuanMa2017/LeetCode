import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] bucket = new int[26];
        for (char task : tasks) {
            bucket[task - 'A']++;
        }
        Arrays.sort(bucket);
        int longest = bucket[25];
        int count = 1;
        for (int i = 24; i >= 0; i--) {
            if (bucket[i] == longest) {
                count++;
            } else {
                break;
            }
        }
        return Math.max(tasks.length, (n + 1) * (longest - 1) + count);
    }
}
