import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String removeDigit(String number, char digit) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String tmp = number.substring(0, i) + number.substring(i + 1);
                list.add(tmp);
            }
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
