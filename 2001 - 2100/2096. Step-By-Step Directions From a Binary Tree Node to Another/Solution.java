class Solution {
    boolean flag;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        dfs(root, startValue, sb1);
        flag = false;
        dfs(root, destValue, sb2);

        while (sb1.length() > 0 && sb2.length() > 0 && sb1.charAt(0) == sb2.charAt(0)) {
            sb1.deleteCharAt(0);
            sb2.deleteCharAt(0);
        }

        String temp = sb1.toString();
        if (sb1.length() > 0) {
            temp = sb1.toString().replace("L", "U");
            temp = temp.replace("R", "U");
        }

        return temp + sb2.toString();
    }

    public void dfs(TreeNode node, int target, StringBuilder path) {
        if (node.val == target) {
            flag = true;
            return;
        }
        if (node.left != null) {
            path.append('L');
            dfs(node.left, target, path);
            if (flag) {
                return;
            }
            path.deleteCharAt(path.length() - 1);
        }
        if (node.right != null) {
            path.append('R');
            dfs(node.right, target, path);
            if (flag) {
                return;
            }
            path.deleteCharAt(path.length() - 1);
        }
    }
}
