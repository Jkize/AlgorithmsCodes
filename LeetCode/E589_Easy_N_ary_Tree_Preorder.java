import java.util.ArrayList;
import java.util.List;

/**
 * E589_Easy_N_ary_Tree_Preorder
 * Runtime: 2 ms, faster than 56.75% of Java online submissions for N-ary Tree
 * Preorder Traversal.
 * Memory Usage: 46.2 MB, less than 44.00% of Java online submissions for N-ary
 * Tree Preorder Traversal.
 * 
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */

public class E589_Easy_N_ary_Tree_Preorder {
    public List<Integer> preorder(Node root) {        
        List<Integer> res = new ArrayList<>();
        _pre(res,root);
        return res;
        
    }
    
    public void _pre(List<Integer> res, Node root){
        if(root!=null){
            res.add(root.val);
            for(Node child:root.children){
                _pre(res,child);
            }
        }
    }
    
}