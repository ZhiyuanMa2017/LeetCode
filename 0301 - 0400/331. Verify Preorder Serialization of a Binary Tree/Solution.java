class Solution {
    public boolean isValidSerialization(String preorder) {
        int edges = 1;
        String[] pres = preorder.split(",");
        for (int i = 0; i < pres.length; i++) {
            edges--;
            if (edges < 0) {
                return false;
            }
            if (!pres[i].equals("#")) {
                edges += 2;
            }
        }
        return edges == 0;
    }
}
