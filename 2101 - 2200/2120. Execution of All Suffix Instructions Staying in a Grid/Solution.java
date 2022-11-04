import java.util.Arrays;

class Solution {
    public int[] executeInstructions(int m, int[] startPos, String s) {
        int[] hor = new int[13];
        int[] ver = new int[13];
        Arrays.fill(hor, s.length());
        Arrays.fill(ver, s.length());
        int h = 6;
        int v = 6;
        int lB = startPos[1] + 1;
        int rB = m - startPos[1];
        int uB = startPos[0] + 1;
        int dB = m - startPos[0];
        int[] result = new int[s.length()];
        int res;
        char c;
        for (int i = s.length() - 1; i >= 0; --i) {
            c = s.charAt(i);
            if (c == 'U') {
                ver[v++] = i;
            } else if (c == 'D') {
                ver[v--] = i;
            } else if (c == 'R') {
                hor[h--] = i;
            } else {
                hor[h++] = i;
            }
            res = s.length();
            res = Math.min(res, hor[h - lB]);
            res = Math.min(res, hor[h + rB]);
            res = Math.min(res, ver[v - uB]);
            res = Math.min(res, ver[v + dB]);
            result[i] = res - i;
        }
        return result;
    }
}
