class Solution {
    public int countPoints(String rings) {
        int[] count = new int[10];
        int res = 0;
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            count[rings.charAt(i + 1) - '0'] |= color == 'R' ? 1 : color == 'G' ? 2 : 4;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 7) {
                res++;
            }
        }
        return res;
    }
}
