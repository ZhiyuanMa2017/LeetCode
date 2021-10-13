import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example 1:
 * <p>
 * Input: [1, 0, 0, 1, 0]
 * Output: 0
 * Explanation:
 * If you answer 0 questions (k = 0) your_result = 0 and your friend_result = -1
 * (2 correct answers and 3 wrong answers).
 * Example 2:
 * <p>
 * Input: [1, 0, 0, 1, 1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1, 1, 1, 0, 1]
 * Output: 2
 */

public class Solution {

    public static void main(String[] args) {
        List<Integer> v = Stream.of(1, 0, 0, 1, 0).collect(Collectors.toList());
        //0
        List<Integer> c = Stream.of(1, 0, 0, 1, 1).collect(Collectors.toList());
        //1
        List<Integer> x = Stream.of(1, 1, 1, 0, 1).collect(Collectors.toList());
        //2
        System.out.println(exam(v));
        System.out.println(exam(c));
        System.out.println(exam(x));

    }

    public static int exam(List<Integer> v) {
        int all = 0;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) == 1) {
                all++;
            } else {
                all--;
            }
        }
        int cur = 0;
        for (int i = 0; i < v.size(); i++) {
            if (cur > all) {
                return i;
            }
            if (v.get(i) == 1) {
                cur++;
                all--;
            } else {
                cur--;
                all++;
            }
        }
        return v.size();
    }
}
