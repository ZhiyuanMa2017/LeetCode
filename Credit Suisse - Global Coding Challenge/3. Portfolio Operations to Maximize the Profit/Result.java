import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    public static int portfolioProfitMaximisation(int maxSum, List<Integer> a, List<Integer> b) {
        int curSum = 0;
        int count = 0;
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.get(0) < b.get(0)) {
                curSum += a.remove(0);
                if (curSum > maxSum) {
                    return count;
                }
                count++;
            } else {
                curSum += b.remove(0);
                if (curSum > maxSum) {
                    return count;
                }
                count++;
            }
        }
        if (a.isEmpty()) {
            while (!b.isEmpty()) {
                curSum += b.remove(0);
                if (curSum > maxSum) {
                    return count;
                }
                count++;
            }
        }
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                curSum += a.remove(0);
                if (curSum > maxSum) {
                    return count;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> a = Stream.of(12, 21, 102).collect(Collectors.toList());
        List<Integer> b = Stream.of(167, 244, 377, 56, 235, 269, 23).collect(Collectors.toList());
        System.out.println(portfolioProfitMaximisation(3696, a, b));
    }
}
