class Solution {
    public String capitalizeTitle(String title) {
        String[] parts = title.split(" ");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].toLowerCase();
            if (parts[i].length() > 2) {
                char c = parts[i].charAt(0);
                Character next = Character.toUpperCase(c);
                parts[i] = next + parts[i].substring(1);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String part : parts) {
            res.append(part).append(" ");
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }
}
