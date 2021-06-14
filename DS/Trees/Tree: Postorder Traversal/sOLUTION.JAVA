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

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/
    public static void postOrder(Node root) {
        //ITERATIVE
        Node temp = root;
        Node p = root;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.empty() && p!=null) {
            p = stack.peek();
                //CHECKING IF LEAF NODE. OR IF PARENT OF RECENTLY PRINTED LEAF
            if((p.left==null && p.right==null) || temp == p.left || temp == p.right) {
                System.out.printf("%d ", p.data);
                stack.pop();
                temp = p;
            } else {//pushing both sides
                if(p.right != null) 
                    stack.push(p.right);
                if(p.left != null) 
                    stack.push(p.left);
            }
        }
    }
    
    public static void RECURSIVEpostOrder(Node root) {
        //RECURSIVE METHOD
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf("%d ", root.data);
        }
    }

	public static Node insert(Node root, int data) {
