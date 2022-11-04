import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
//        int compare(T o1, T o2) {
//            if (o1 < o2)
//                return -1;
//            else if (o1 == o2)
//                return 0;
//            else // o1 > o2
//                return 1;
//        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] parts1 = o1.split(" ", 2);
                String[] parts2 = o2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(parts1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(parts2[1].charAt(0));
                if (!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else if (!isDigit1 && !isDigit2) {
                    if (parts1[1].compareTo(parts2[1]) != 0) {
                        return parts1[1].compareTo(parts2[1]);
                    } else {
                        return parts1[0].compareTo(parts2[0]);
                    }
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(logs, comparator);
        return logs;
    }
}
