class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        dfs(root, startValue, sb1);
        dfs(root, destValue, sb2);
        int index = 0;
        while (index < sb1.length() && index < sb2.length()) {
            if (sb1.charAt(index) == sb2.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int j = sb1.length() - 1; j >= index; j--) {
            res.append("U");
        }
        res.append(sb2.substring(index));
        return res.toString();
    }

    private boolean dfs(TreeNode root, int target, StringBuilder sb) {
        if (root.val == target) {
            return true;
        }
        if (root.left != null) {
            sb.append("L");
            if (dfs(root.left, target, sb)) {
                return true;
            } else {
                sb.setLength(sb.length() - 1);
            }
        }
        if (root.right != null) {
            sb.append("R");
            if (dfs(root.right, target, sb)) {
                return true;
            } else {
                sb.setLength(sb.length() - 1);
            }
        }
        return false;
    }
}
