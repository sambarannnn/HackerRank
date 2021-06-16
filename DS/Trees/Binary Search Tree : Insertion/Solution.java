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
  
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

    public static Node Rinsert(Node p,int data) {
        //RECURSIVE INSERT
        Node temp = null;
        if(p == null) {
            temp = new Node(data);
            return temp;
        }
        if(data < p.data)
            p.left = insert(p.left, data);
        else if(data > p.data)
            p.right = insert(p.right, data);
        //if its equal then no right or left child is added, otherwise it returns modified tree(w new node inserted)    
        return p;
    }

	public static Node ITRinsert(Node root,int data) {
        //ITERATIVE
        if(root == null) {
            root = new Node(data);
            return root;
        }
        Node trailing = null;
        Node fwd = root;
        while(fwd != null) {
            trailing = fwd;
            if(data == fwd.data)
//equaldata is already present so u return out of func as u cant insert duplicate node
                return root;
            else if(data < fwd.data)
                fwd = fwd.left;
            else
                fwd = fwd.right;
        }
    	//now fwd is null and trailing is at correct insertion point
        Node temp = new Node(data);
        temp.data = data;
        if(temp.data < trailing.data)
            trailing.left = temp;
        else
            trailing.right = temp;
            
        return root;
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
      	preOrder(root);
    }
}
