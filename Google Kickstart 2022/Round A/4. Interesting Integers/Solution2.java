import java.util.*;

public class Solution2 {
    // https://codingcompetitions.withgoogle.com/kickstart/submissions/00000000008cb33e/000000000054f3c8
    static Scanner sc = new Scanner(System.in);
    static Map<Long, Long>[][] memo;
    static Map<Long, Long> map;
    static Map<Long, Long> def = new HashMap<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; ++i) {
            solve(i);
        }
    }


    private static void solve(int t) {
        String s = sc.nextLine();

        String[] row = s.split(" ");

        long a = Long.parseLong(row[0]);
        long b = Long.parseLong(row[1]);

        int l = (b + "").length();
        memo = new Map[l][120];

        for (int i = 0; i < l; ++i) {
            for (int j = 0; j < 120; ++j) {
                memo[i][j] = new HashMap<>();
            }
        }

        long a1 = getCount(a);

        for (int i = 0; i < l; ++i) {
            for (int j = 0; j < 120; ++j) {
                memo[i][j] = new HashMap<>();
            }
        }

        long a2 = getCount(b);

        long result = a2 - a1;

        if (isValid(a)) {
            ++result;
        }

        print(t, result);
    }

    private static long getCount(long num) {
        long[] arr = new long[(num + "").length()];
        long[] powers = new long[arr.length];

        long pow = 1;
        long val = num;

        for (int j = powers.length - 1; j >= 0; --j) {
            powers[j] = pow;
            pow *= 10;
            arr[j] = val % 10;
            val /= 10;
        }

        return getCount(arr, powers, num, 0, 0, true, 0, 1);
    }

    private static long getCount(long[] arr, long[] powers, long num, long current,
                                 int idx, boolean equal, int sum, long product) {

        if (idx == arr.length) {
            return sum == 0 ? 0 : product % sum == 0 ? 1 : 0;
        } else if (product == 0) {
            return equal ? num - current + 1 : powers[idx] * 10;
        } else if (!equal && memo[idx][sum].containsKey(product)) {
            return memo[idx][sum].get(product);
        }

        int nSum;
        long nProduct, nCurrent;
        boolean nEqual;

        long result = 0;

        for (int i = 0; i < 10; ++i) {
            if (i > arr[idx] && equal) {
                break;
            }

            nSum = sum + i;
            nProduct = product * i;

            if (nSum == 0) {
                nProduct = 1;
            }

            nEqual = equal && i == arr[idx];
            nCurrent = current + powers[idx] * i;

            result += getCount(arr, powers, num, nCurrent, idx + 1, nEqual, nSum, nProduct);
        }

        if (!equal) {
            memo[idx][sum].put(product, result);
        }
        return result;
    }

    private static boolean isValid(long val) {
        long mod;
        long sum = 0;
        long product = 1;

        while (val > 0) {
            mod = val % 10;
            val /= 10;
            sum += mod;
            product *= mod;
        }

        return product % sum == 0;
    }

    private static void print(int t, long result) {
        System.out.println("Case #" + t + ": " + result);
    }


}
