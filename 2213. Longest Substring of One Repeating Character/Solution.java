import java.util.TreeMap;

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int n = queryCharacters.length();
        int[] res = new int[n];
        TreeMap<Integer, Integer> lengthFreq = new TreeMap<>();
        TreeMap<Integer, Integer> span = new TreeMap<>();
        int i = 0;
        int j = 1;
        while (i < len) {
            if (j == len || chars[i] != chars[j]) {
                lengthFreq.put(j - i, lengthFreq.getOrDefault(j - i, 0) + 1);
                span.put(i, j - 1);
                i = j;
            }
            j++;
        }

        for (int k = 0; k < n; k++) {
            int position = queryIndices[k];
            if (chars[position] != queryCharacters.charAt(k)) {
                int left = span.floorKey(position);
                int right = span.remove(left);

                int length = right - left + 1;
                lengthFreq.put(length, lengthFreq.get(length) - 1);
                if (lengthFreq.get(length) == 0) {
                    lengthFreq.remove(length);
                }
                if (left < position) {
                    span.put(left, position - 1);
                    lengthFreq.put(position - left, lengthFreq.getOrDefault(position - left, 0) + 1);
                }
                if (right > position) {
                    span.put(position + 1, right);
                    lengthFreq.put(right - position, lengthFreq.getOrDefault(right - position, 0) + 1);
                }

                chars[position] = queryCharacters.charAt(k);

                left = position;
                right = position;

                if (position > 0 && chars[position] == chars[position - 1]) {
                    left = span.floorKey(position);
                    length = span.remove(left) - left + 1;
                    lengthFreq.put(length, lengthFreq.get(length) - 1);
                    if (lengthFreq.get(length) == 0) {
                        lengthFreq.remove(length);
                    }
                }
                if (position < len - 1 && chars[position] == chars[position + 1]) {
                    int cur = span.ceilingKey(position);
                    right = span.remove(cur);
                    length = right - cur + 1;
                    lengthFreq.put(length, lengthFreq.get(length) - 1);
                    if (lengthFreq.get(length) == 0) {
                        lengthFreq.remove(length);
                    }
                }
                span.put(left, right);
                lengthFreq.put(right - left + 1, lengthFreq.getOrDefault(right - left + 1, 0) + 1);
            }
            res[k] = lengthFreq.lastKey();
        }
        return res;
    }
}
