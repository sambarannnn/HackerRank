/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/  
    boolean isBST(Node root,int min,int max)
    {
        if(root == null)
            return true;    //NULL is not a node to be checked. So, return true always
        if(root.data > min && root.data < max)
            return (isBST(root.left,min,root.data) && isBST(root.right,root.data,max));
        return false;
    }

    boolean checkBST(Node root) {
        // Your code here
        if(root == null)
            return true;
        if(isBST(root.left,0,root.data) && isBST(root.right,root.data,Integer.MAX_VALUE))
            return true;
        return false;
    }
