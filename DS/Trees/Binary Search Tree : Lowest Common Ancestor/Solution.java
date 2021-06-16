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
    static Node lca(Node n, int v1, int v2) {
        //ITERATIVE
        while (n != null) {
            if (n.data > v1 && n.data > v2) {
                n = n.left;
            } else if (n.data < v1 && n.data < v2) {
                n = n.right;
            } else {
                break;
            } 
        }
        return n;
    }
    
	static Node Rlca(Node root,int v1,int v2)
    {
        //RECURSIVE
        //Decide if you have to call recursively
        //Samller than both
        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        //Bigger than both
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }

        //Else solution already found
        return root;
    }

	public static Node insert(Node root, int data) {
