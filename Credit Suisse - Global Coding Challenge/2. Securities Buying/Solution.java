import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Solution {

    static int securitiesBuying(int z, ArrayList<Integer> securityValue) {
        int n = securityValue.size();
        int[][] s = new int[n][2];
        for (int i = 0; i < n; i++) {
            s[i] = new int[]{securityValue.get(i), i + 1};
        }
        Arrays.sort(s, (a, b) -> (a[0] - b[0]));
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + s[i][0] * s[i][1] > z) {
                int no = (z - sum) / s[i][0];
                count += no;
                return count;
            } else {
                sum += s[i][0] * s[i][1];
                count += s[i][1];
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        List<Integer> l = Stream.of(17, 24, 7, 45, 15, 14, 37, 40, 8, 23, 27, 17).collect(Collectors.toList());
        System.out.println(securitiesBuying(64, (ArrayList<Integer>) l));
    }
}
