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
	public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        Node p = root;
        System.out.printf("%d ", p.data);//printing root
        //enqueing root
        queue.add(p);
        while(!queue.isEmpty()) {
            p = queue.remove();
            //add left first so its visited first in next iteration (FIFO)
            if(p.left != null) {
                System.out.printf("%d ", p.left.data);
                //enqueue for future visit
                queue.add(p.left);
            }
            if(p.right != null) {
                System.out.printf("%d ", p.right.data);
                //enqueue for future visit
                queue.add(p.right);
            }
        }
    }

	public static Node insert(Node root, int data) {
