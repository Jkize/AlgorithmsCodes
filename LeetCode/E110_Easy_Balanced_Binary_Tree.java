public class E110_Easy_Balanced_Binary_Tree {

    /**
     * Runtime: 1 ms, faster than 99.10% of Java online submissions for Balanced
     * Binary Tree.
     * Memory Usage: 42.3 MB, less than 86.67% of Java online submissions for
     * Balanced Binary Tree.
     * 
     * Time Complexity O(N^2)
     * 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        boolean balance = Math.abs(heightTree(root.left) - heightTree(root.right)) <= 1;
        if (!balance)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int heightTree(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(heightTree(root.left) + 1, heightTree(root.right) + 1);

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Balanced
     * Binary Tree.
     * Memory Usage: 42.1 MB, less than 88.31% of Java online submissions for
     * Balanced Binary Tree.
     * 
     * @param root
     * @return
     */
    public int dfsHeight(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalancedV2(TreeNode root) {
        return dfsHeight(root) != -1;
    }

}
