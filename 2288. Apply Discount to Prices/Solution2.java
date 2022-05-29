class Solution2 {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        double multiple = (double) (100 - discount) / 100;
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.charAt(0) == '$') {
                try {
                    double cur = Double.parseDouble(word.substring(1));
                    cur *= multiple;
                    words[i] = String.format("$%.2f", cur);
                } catch (NumberFormatException ignored) {
                }
            }
            if (!first) {
                sb.append(" ");
            }
            first = false;
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
