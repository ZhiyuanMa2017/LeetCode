import java.util.Arrays;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordCount = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordCount[i] = f(words[i]);
        }
        Arrays.sort(wordCount);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = f(queries[i]);
            res[i] = binarySearch(wordCount, cur);
        }
        return res;
    }

    public int binarySearch(int[] nums, int num) {
        int l = 0;
        int h = nums.length;
        int target = num + 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums.length - l;
    }

    private int f(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return count[i];
            }
        }
        return -1;
    }
}
