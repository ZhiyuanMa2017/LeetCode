import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    String S;

    public String longestDupSubstring(String s) {
        S = s;
        int n = S.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) S.charAt(i) - (int) 'a';
        }
        int a = 26;
        int modulus = 1000000007;
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (search(mid, a, modulus, n, nums) != -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int start = search(left - 1, a, modulus, n, nums);
        return S.substring(start, start + left - 1);
    }

    public int search(int L, int a, long modulus, int n, int[] nums) {
        long hash = 0;
        for (int i = 0; i < L; i++) {
            hash = (hash * a + nums[i]) % modulus;
        }

        Map<Long, List<Integer>> seen = new HashMap<>();
        seen.putIfAbsent(hash, new ArrayList<>());
        seen.get(hash).add(0);

        long aL = 1;
        for (int i = 1; i <= L; i++) {
            aL = (aL * a) % modulus;
        }

        for (int start = 1; start < n - L + 1; start++) {
            hash = (hash * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            hash = (hash + nums[start + L - 1]) % modulus;
            List<Integer> hits = seen.get(hash);
            if (hits != null) {
                String cur = S.substring(start, start + L);
                for (Integer hit : hits) {
                    String candidate = S.substring(hit, hit + L);
                    if (candidate.equals(cur)) {
                        return hit;
                    }
                }
            }
            seen.putIfAbsent(hash, new ArrayList<>());
            seen.get(hash).add(start);
        }
        return -1;
    }
}
