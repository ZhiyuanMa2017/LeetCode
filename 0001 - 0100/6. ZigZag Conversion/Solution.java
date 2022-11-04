class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int rowId = 0;
        int upOrDown = -1;
        for (char c : s.toCharArray()) {
            stringBuilders[rowId].append(c);
            if (rowId == 0 || rowId == numRows - 1) {
                upOrDown = 0 - upOrDown;
            }
            rowId += upOrDown;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : stringBuilders) {
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();
    }
}
