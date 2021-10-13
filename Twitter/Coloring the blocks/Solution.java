import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static int colorBlocks(List<List<Integer>> color) {
        for (int i = 1; i < color.size(); i++) {
            color.get(i).set(0, color.get(i).get(0) + Math.min(color.get(i).get(1), color.get(i).get(2)));
            color.get(i).set(1, color.get(i).get(1) + Math.min(color.get(i).get(0), color.get(i).get(2)));
            color.get(i).set(2, color.get(i).get(2) + Math.min(color.get(i).get(1), color.get(i).get(0)));
        }
        int n = color.size();
        return Math.min(Math.min(color.get(n - 1).get(0), color.get(n - 1).get(1)), color.get(n - 1).get(2));
    }

    public static void main(String[] args) {
        List<Integer> a = Stream.of(1, 2, 2).collect(Collectors.toList());
        List<Integer> b = Stream.of(2, 2, 1).collect(Collectors.toList());
        List<Integer> c = Stream.of(2, 1, 2).collect(Collectors.toList());
        List<List<Integer>> color = Stream.of(a, b, c).collect(Collectors.toList());
        System.out.println(colorBlocks(color));
    }
}
