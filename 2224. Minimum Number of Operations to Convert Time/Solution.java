class Solution {
    public int convertTime(String current, String correct) {
        int cur = (current.charAt(0) * 10 + current.charAt(1)) * 60 + current.charAt(3) * 10 + current.charAt(4);
        int right = (correct.charAt(0) * 10 + correct.charAt(1)) * 60 + correct.charAt(3) * 10 + correct.charAt(4);
        int diff = right - cur;
        int count = 0;
        count += diff / 60;
        diff %= 60;
        count += diff / 15;
        diff %= 15;
        count += diff / 5;
        diff %= 5;
        count += diff;
        return count;
    }
}
