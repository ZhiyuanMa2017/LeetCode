class Solution {
    public int largestVariance(String s) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == j) {
                    continue;
                }
                char a = (char) (i + 'a');
                char b = (char) (j + 'a');
                int diff = 0;
                int diffWithB = -s.length();
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == a) {
                        diff++;
                        diffWithB++;
                    } else if (s.charAt(k) == b) {
                        diff--;
                        diffWithB = diff;
                        diff = Math.max(diff, 0);
                    }
                    res = Math.max(res, diffWithB);
                }
            }
        }
        return res;
    }
}
