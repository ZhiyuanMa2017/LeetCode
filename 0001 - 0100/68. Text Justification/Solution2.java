import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        int i = 0;
        List<String> list = new ArrayList<>();
        while (i < n) {
            list = new ArrayList<>();
            list.add(words[i]);
            int total = words[i].length();
            int wordsLength = words[i].length();
            i++;
            while (i < n && total + 1 + words[i].length() <= maxWidth) {
                list.add(words[i]);
                total += 1 + words[i].length();
                wordsLength += words[i].length();
                i++;
            }
            if (i == n || list.size() == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(list.get(0));
                for (int j = 1; j < list.size(); j++) {
                    sb.append(" ").append(list.get(j));
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                res.add(sb.toString());
                if (i == n) {
                    break;
                } else {
                    continue;
                }
            }
            int spaceWidth = maxWidth - wordsLength;
            int count = list.size();
            int spaceWidthEach = spaceWidth / (count - 1);
            int remain = spaceWidth % (count - 1);
            StringBuilder space = new StringBuilder();
            for (int j = 0; j < spaceWidthEach; j++) {
                space.append(" ");
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
                if (j == list.size() - 1) {
                    break;
                }
                sb.append(space);
                if (remain > 0) {
                    sb.append(" ");
                    remain--;
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
