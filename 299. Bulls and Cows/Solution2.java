class Solution2 {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] s = new int[10];
        int[] g = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                A++;
            } else {
                s[cs - '0']++;
                g[cg - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            B += Math.min(s[i], g[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A).append("A").append(B).append("B");
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getHint("1122", "2211"));
    }
}
