class Solution2 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int next = 25;
        for (int i = 25; i >= 0; i--) {
            if (count[i] > 0) {
                char c = (char) (i + 'a');
                int times = Math.min(repeatLimit, count[i]);
                sb.append(String.valueOf(c).repeat(times));
                count[i] -= times;
            }
            if (count[i] > 0) {
                while (next >= i || next >= 0 && count[next] == 0) {
                    next--;
                }
                if (next < 0) {
                    break;
                }
                sb.append((char) (next + 'a'));
                count[next]--;
                i++;
            }
        }
        return sb.toString();
    }
}
