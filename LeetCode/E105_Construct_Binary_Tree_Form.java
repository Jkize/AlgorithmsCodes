import java.util.HashMap;
import java.util.Map;

/**
 * E105_Construct_Binary_Tree_Form
 * 
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class E105_Construct_Binary_Tree_Form {

    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }


    //Python Solution

    /*
    class Solution:
        def buildTree(self, preorder, inorder):
            if inorder:
                INDEX = inorder.index(preorder.pop(0))
                root = TreeNode(inorder[INDEX])
                root.left = self.buildTree(preorder, inorder[:INDEX])
                root.right = self.buildTree(preorder, inorder[INDEX+1:])
    
                return root
     */

}