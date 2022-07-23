import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E117_Medium_Populationg_Next_Right_Pointers {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Node res = root;
        if (root == null)
            return root;

        List<Node> list = new ArrayList<>();
        list.add(root);
        while (list.size() > 0) {
            List<Node> child = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {

                if (i <list.size() - 1) {
                    list.get(i).next = list.get(i + 1);
                } 

                if (list.get(i).left != null) {
                    child.add(list.get(i).left);
                }
                if (list.get(i).right != null) {
                    child.add(list.get(i).right);

                }
            }
            list = child;
        }

        return res;
    }

    public Node connectV2(Node root) {
        if(root==null) return null;
        
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        
        Node node;
        int levelSize;
        while(!q.isEmpty()){
            levelSize = q.size();
            
            for(int i=0; i<levelSize; i++){
                node = q.poll();
                if(i<levelSize-1) node.next = q.peek();                        
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);            
            }
        }
        return root;
    }

}
