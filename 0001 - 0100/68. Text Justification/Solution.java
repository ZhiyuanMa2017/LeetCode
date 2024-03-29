import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> result = new ArrayList<>();
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right].length();
        right++;
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
            sum += 1 + words[right].length();
            right++;
        }
        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right == left) {
            return padResult(words[left], maxWidth);
        }
        boolean isLastLine = right == words.length - 1;
        int spacesBetween = right - left;
        int totalSpaces = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpaces / spacesBetween);
        int remainder = isLastLine ? 0 : totalSpaces % spacesBetween;
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(words[i]).append(space).append(remainder > 0 ? " " : "");
            remainder--;
        }
        return padResult(sb.toString().trim(), maxWidth);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) {
            wordsLength += words[i].length();
        }
        return wordsLength;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int lengtgh) {
        return new String(new char[lengtgh]).replace('\0', ' ');
    }
}
