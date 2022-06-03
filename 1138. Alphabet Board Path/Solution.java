class Solution {
    public String alphabetBoardPath(String target) {
        int x = 0;
        int y = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : target.toCharArray()) {
            int i = (c - 'a') / 5;
            int j = (c - 'a') % 5;
            // to deal with z:
            // up before right
            sb.append("U".repeat(Math.max(0, x - i)));
            sb.append("R".repeat(Math.max(0, j - y)));
            // left before down
            sb.append("L".repeat(Math.max(0, y - j)));
            sb.append("D".repeat(Math.max(0, i - x)));
            sb.append("!");
            x = i;
            y = j;
        }
        return sb.toString();
    }
}
