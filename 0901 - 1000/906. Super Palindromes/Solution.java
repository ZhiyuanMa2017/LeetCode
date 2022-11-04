import java.util.ArrayList;
import java.util.List;

class Solution {
    public int superpalindromesInRange(String left, String right) {
        List<Long> palindromes = new ArrayList<>();
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);

        double lowLimit = Math.sqrt(l);
        double highLimit = Math.sqrt(r);
        long lowLimitLen = Double.toString(lowLimit).length();
        long highLimitLen = Double.toString(highLimit).length();

        int res = 0;

        for (long i = 1; i < 9; i++) {
            palindromes.add(i);
        }

        for (long i = 1; i < 10000; i++) {

            String le = Long.toString(i);
            String ri = new StringBuilder(le).reverse().toString();
            if (le.length() * 2L + 1 < lowLimitLen) {
                continue;
            }
            if (le.length() * 2L + 1 > highLimitLen) {
                break;
            }
            palindromes.add(Long.parseLong(le + ri));
            for (long j = 0; j < 10; j++) {
                palindromes.add(Long.parseLong(le + j + ri));
            }
        }
        for (Long palindrome : palindromes) {
            long square = palindrome * palindrome;
            if (!isPalindrome(Long.toString(square))) {
                continue;
            }
            if (square <= r && square >= l) {
                res++;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
