class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        double beishu = (double) (100 - discount) / 100;
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (valid(word)) {
                sb.append(change(word, beishu)).append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private String change(String s, double beishu) {
        long num = Long.parseLong(s.substring(1));
        double res = num * beishu;
        return String.format("$%.2f", res);

    }

    private boolean valid(String s) {
        if (s.length() < 2) {
            return false;
        }
        if (s.charAt(0) != '$') {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
