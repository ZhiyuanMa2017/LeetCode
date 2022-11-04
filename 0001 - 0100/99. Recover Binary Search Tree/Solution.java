class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode previous = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {

                if (previous != null && previous.val > curr.val) {
                    if (first == null) {
                        first = previous;
                        second = curr;
                    } else {
                        second = curr;
                    }
                }
                previous = curr;

                curr = curr.right;
            } else {
                TreeNode tmp = curr.left;
                while (tmp.right != null && tmp.right != curr) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = curr;
                    curr = curr.left;
                } else {
                    tmp.right = null;

                    if (previous != null && previous.val > curr.val) {
                        if (first == null) {
                            first = previous;
                            second = curr;
                        } else {
                            second = curr;
                        }
                    }
                    previous = curr;

                    curr = curr.right;
                }
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    // Morris Traversal
    //1. 初始化当前节点 cur 为 root 节点.
    //
    //2. 如果 cur 没有左孩子，则输出当前节点并将其右孩子作为当前节点,即 cur = cur->right。
    //
    //3. 如果 cur 有左孩子，在当前节点 cur 的左子树中找到当前节点 cur 在中序遍历下的前驱节点。
    //
    //   a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
    //
    //   b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
    //
    //4. 重复以上2、3直到当前节点为空。

}
