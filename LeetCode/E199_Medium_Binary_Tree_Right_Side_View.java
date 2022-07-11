import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E199_Medium_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // BFS
        List<TreeNode> childs = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                childs.add(root.left);
            }
            if (root.right != null) {
                childs.add(root.right);
            }
        }

        while (childs.size() != 0) {
            list.add(childs.get(childs.size() - 1).val);
            List<TreeNode> newChilds = new ArrayList<>();
            for (TreeNode child : childs) {
                if (child.left != null) {
                    newChilds.add(child.left);
                }
                if (child.right != null) {
                    newChilds.add(child.right);
                }
            }
            childs = newChilds;

        }
        return list;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (size == 0)
                    res.add(cur.val);

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }

        return res;
    }
}
