import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> thisLine = new ArrayList<>();
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < thisLine.size() - 1; j++) {
                thisLine.set(j, thisLine.get(j) + thisLine.get(j + 1));
            }
            thisLine.add(0, 1);
            rows.add(new ArrayList<>(thisLine));
        }
        return rows;
    }
}
