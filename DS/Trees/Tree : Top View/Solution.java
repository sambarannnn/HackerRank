import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    static class TreeNode{
        Node node;
        int level;
        public TreeNode(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public static void topView(Node root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        //first - stores the level of the node
        //second - stores the node.data
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    //Treemap sorted from leftmost to rightmost i.e. ascending order acc to key so negative level ones at left then 0 then +ve so easier to print later on
        
        //adding root
        queue.add(new TreeNode(root, 0));
        TreeNode t;
        while(!queue.isEmpty()) {
            t = queue.remove();
            
            //put only first appearance of key in the map since we are traversing in level order fashion that is top to bottom, we need only top value
            if(!map.containsKey(t.level)) {//adds in ascending sort so easier to print later
                map.put(t.level, t.node.data);
            }
            
            if(t.node.left != null) {
                queue.add(new TreeNode(t.node.left, t.level-1));
            }
            if(t.node.right != null) {
                queue.add(new TreeNode(t.node.right, t.level+1));
            }
        }
        //since already sorted (cuz TreeMap), print from left to right
        for (Integer value : map.values()) {
            System.out.printf("%d ", value);
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
