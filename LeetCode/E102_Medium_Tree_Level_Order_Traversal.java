import java.util.ArrayList;
import java.util.List;

public class E102_Medium_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);   //Add the first node

        while (!nodes.isEmpty()) {
            List<Integer> values = new ArrayList<>(); //Initial for every stage

            List<TreeNode> childNodes = new ArrayList<>(); //Childs about every TreeNode in nodes
            for (TreeNode nd : nodes) {  //For every node in nodes
                values.add(nd.val);      //Add value in the stage
                if (nd.left != null) {          //Ask it has left child the node and put in childNodes
                    childNodes.add(nd.left);
                }
                if (nd.right != null) {         //Ask if it has right child the node and put in childNodes
                    childNodes.add(nd.right);
                }
            }
            res.add(values);      //add the all stage
            nodes = childNodes;   //Overrading the nodes with the childnodes
        }

        return res;

    }
    
}
