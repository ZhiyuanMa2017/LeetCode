class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int cur = s.charAt(i) - '0';
                if (cur > first) {
                    second = first;
                    first = cur;
                } else if (first > cur && cur > second) {
                    second = cur;
                }
            }
        }
        return second;
    }
}
