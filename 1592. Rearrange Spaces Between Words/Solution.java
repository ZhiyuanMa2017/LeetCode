import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int count = 0;
        while (i < text.length()) {
            int j = i + 1;
            if (text.charAt(i) == ' ') {
                while (j < text.length() && text.charAt(j) == ' ') {
                    j++;
                }
                count += j - i;
            } else {
                while (j < text.length() && text.charAt(j) != ' ') {
                    j++;
                }
                list.add(text.substring(i, j));
            }
            i = j;
        }
        int quotient;
        int remainder;
        if (list.size() == 1) {
            quotient = 0;
            remainder = count;
        } else {
            quotient = count / (list.size() - 1);
            remainder = count % (list.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            sb.append(list.get(j));
            if (j != list.size() - 1) {
                sb.append(" ".repeat(quotient));
            }
        }
        sb.append(" ".repeat(remainder));
        return sb.toString();
    }
}
