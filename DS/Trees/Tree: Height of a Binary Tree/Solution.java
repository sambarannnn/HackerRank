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
	public static int height(Node root) {
      	// Write your code here.
        int leftheight;
        int rightheight;
        if(root!=null) {
            leftheight = height(root.left);
            rightheight = height(root.right);
            
            if(leftheight > rightheight)
                return leftheight+1;
            else
                return rightheight+1;
        } else {
            return -1;//or 0
        }
    }

	public static Node insert(Node root, int data) {
