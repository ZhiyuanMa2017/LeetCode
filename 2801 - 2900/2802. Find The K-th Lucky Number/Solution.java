class Solution {
    public String kthLuckyNumber(int k) {
        String b = Integer.toBinaryString(k + 1);
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                res.append(7);
            } else {
                res.append(4);
            }
        }
        return res.toString();
    }
}
