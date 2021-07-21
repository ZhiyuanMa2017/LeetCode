class Solution {
    public String pushDominoes(String dominoes) {
        String d = 'L' + dominoes + 'R';
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, j = 1; j < d.length(); j++) {
            if (d.charAt(j) == '.') {
                continue;
            }
            int lenBetween = j - i - 1;
            if (i > 0) {
                stringBuilder.append(d.charAt(i));
            }
            if (d.charAt(i) == d.charAt(j)) {
                stringBuilder.append(String.valueOf(d.charAt(i)).repeat(Math.max(0, lenBetween)));
            } else if (d.charAt(i) == 'L' && d.charAt(j) == 'R') {
                stringBuilder.append(".".repeat(Math.max(0, lenBetween)));
            } else {
                stringBuilder.append("R".repeat(Math.max(0, lenBetween / 2)));
                if (lenBetween % 2 == 1) {
                    stringBuilder.append('.');
                }
                stringBuilder.append("L".repeat(Math.max(0, lenBetween / 2)));
            }
            i = j;
        }
        return stringBuilder.toString();
    }
}
