class Solution {
    public static String decodeAtIndex(String S, int K) {
        long slength = 0;
        int i;
        for (i = 0; slength < K; i++) {
            Character ii = S.charAt(i);
            if (Character.isDigit(S.charAt(i))) {
                slength *= Character.getNumericValue(S.charAt(i));
            } else {
                slength += 1;
            }
        }
        i--;
        while (true) {
            if (Character.isDigit(S.charAt(i))) {
                slength /= Character.getNumericValue(S.charAt(i));
                K %= slength;
            } else if (K % slength == 0) {
                return String.valueOf(S.charAt(i));
            } else {
                slength--;
            }
            i--;
        }
    }
}
