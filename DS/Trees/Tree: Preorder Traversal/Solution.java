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
    public static void preOrder(Node root) {
        //ITERATIVE METHOD
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        while(p != null || !stack.empty()) {
            if(p != null) {
                System.out.printf("%d ", p.data);
                stack.push(p);
                p = p.left;
            } else {//when p becomes null
                p = stack.pop();
                p = p.right;
            }
        }
    }
    
    public static void RECURSIVEpreOrder(Node root) {
        if(root != null) {
            System.out.printf("%d ", root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

	public static Node insert(Node root, int data) {
