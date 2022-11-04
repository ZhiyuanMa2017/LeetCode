class Solution {
    public boolean areNumbersAscending(String s) {
        String[] parts = s.split(" ");
        int previous = 0;
        for (int i = 0; i < parts.length; i++) {
            if (Character.isDigit(parts[i].charAt(0))) {
                int num = Integer.parseInt(parts[i]);
                if (num <= previous) {
                    return false;
                }
                previous = num;
            }
        }
        return true;
    }
}
