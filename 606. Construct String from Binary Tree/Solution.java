class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        String l = tree2str(root.left);
        String r = tree2str(root.right);
        if (root.right != null) {
            sb.append("(").append(l).append(")").append("(").append(r).append(")");
        } else if (root.left != null) {
            sb.append("(").append(l).append(")");
        }
        return sb.toString();
    }
}
