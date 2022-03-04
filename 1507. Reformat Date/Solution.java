import java.util.HashMap;
import java.util.Map;

class Solution {
    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>() {{
            put("Jan", "01");
            put("Feb", "02");
            put("Mar", "03");
            put("Apr", "04");
            put("May", "05");
            put("Jun", "06");
            put("Jul", "07");
            put("Aug", "08");
            put("Sep", "09");
            put("Oct", "10");
            put("Nov", "11");
            put("Dec", "12");
        }};
        String[] parts = date.split(" ");
        String year = parts[2];
        String month = months.get(parts[1]);
        StringBuilder day = new StringBuilder();
        for (int i = 0; i < parts[0].length(); i++) {
            if (parts[0].charAt(i) >= '0' && parts[0].charAt(i) <= '9') {
                day.append(parts[0].charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        res.append(year).append("-").append(month).append("-");
        if (day.length() == 1) {
            res.append(0).append(day);
        } else {
            res.append(day);
        }
        return res.toString();
    }
}
