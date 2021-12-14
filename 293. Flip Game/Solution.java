import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.startsWith("++", i)) {
                StringBuilder sb = new StringBuilder();
                sb.append(currentState.substring(0, i))
                        .append("--")
                        .append(currentState.substring(i + 2));
                res.add(sb.toString());
            }
        }
        return res;
    }
}
