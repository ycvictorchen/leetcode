/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = this.getHeight(root.left);
        int hr = this.getHeight(root.right);
        return (1 << (hl > hr ? hr : hl)) + this.countNodes(hl > hr ? root.left : root.right);
    }
    private int getHeight(TreeNode node) {
        return node == null ? 0 : 1 + this.getHeight(node.left);
    }
}