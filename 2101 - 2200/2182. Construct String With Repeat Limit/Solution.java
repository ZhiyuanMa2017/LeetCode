class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int len;
        while (true) {
            len = sb.length();
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    if (sb.length() > 0 && (char) (i + 'a') == sb.charAt(sb.length() - 1)) {
                        continue;
                    }
                    if (sb.length() > 0 && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        if (sb.charAt(sb.length() - 1) - 'a' > i) {
                            sb.append((char) (i + 'a'));
                            count[i]--;
                        } else {
                            sb.append(String.valueOf((char) (i + 'a'))
                                    .repeat(Math.min(repeatLimit, count[i])));
                            count[i] -= Math.min(repeatLimit, count[i]);
                        }
                    } else {
                        sb.append(String.valueOf((char) (i + 'a'))
                                .repeat(Math.min(repeatLimit, count[i])));
                        count[i] -= Math.min(repeatLimit, count[i]);
                    }
                    break;
                }
            }
            if (len == sb.length()) {
                break;
            }
        }
        return sb.toString();
    }
}
