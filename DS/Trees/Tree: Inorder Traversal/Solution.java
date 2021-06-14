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
    public static void RECURSIVEinOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.printf("%d ", root.data);
            inOrder(root.right);
        }
    }

    public static void ITRinOrder(Node root) {
        //ITR
        Node p = root;
        Stack<Node> stack = new Stack<Node>();
        while(!stack.empty() || p !=null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                System.out.printf("%d ", p.data);
                p = p.right;
            }
        }
    }

	public static Node insert(Node root, int data) {
