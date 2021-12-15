class Solution3 {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                A++;
            } else {
                if (count[cg - '0'] < 0) {
                    B++;
                }
                if (count[cs - '0'] > 0) {
                    B++;
                }
                count[cg - '0']++;
                count[cs - '0']--;
            }
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
