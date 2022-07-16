public class E100_Easy_Same_Tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == p) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null) || p.val != q.val) {
            return false;
        }

        boolean left = isSameTree((p != null) ? p.left : null, (q != null) ? q.left : null);
        if (!left)
            return false;
        boolean right = isSameTree((p != null) ? p.right : null, (q != null) ? q.right : null);

        if (!right)
            return false;

        return true;

    }

    //Five lines 
    public boolean isSameTreeV2(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
