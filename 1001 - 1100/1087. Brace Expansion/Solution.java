import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] expand(String s) {
        s = s.replace('{', ' ').replace('}', ' ');
        String[] options = s.strip().split(" ");
        List<String> l = new ArrayList<>();
        l.add("");
        for (String option : options) {
            List<String> temp = new ArrayList<>();
            if (option.length() > 1) {
                String[] curOptions = option.split(",");
                for (String curOption : curOptions) {
                    for (String s1 : l) {
                        temp.add(s1 + curOption);
                    }
                }
            } else {
                for (String s1 : l) {
                    temp.add(s1 + option);
                }
            }
            l = temp;
        }
        Collections.sort(l);
        String[] res = new String[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}
