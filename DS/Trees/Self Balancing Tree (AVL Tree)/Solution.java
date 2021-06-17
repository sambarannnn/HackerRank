	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

    static Node LLRotation(Node p) {
        Node pl = p.left;
        Node plr = pl.right;
        
        pl.right = p;
        p.left = plr;
        
        p.ht = NodeHeight(p);
        pl.ht = NodeHeight(pl);
        
        return pl;
    }

    static Node LRRotation(Node p) {
        Node pl = p.left;
        Node plr = pl.right;
        
        pl.right = plr.left;
        p.left = plr.right;
        plr.left = pl;
        plr.right = p;
        
        p.ht = NodeHeight(p);
        pl.ht = NodeHeight(pl);
        plr.ht = NodeHeight(plr);
        
        return plr;
    }

    static Node RRRotation(Node p) {
        Node pr = p.right;
        Node prl = pr.left;
        
        pr.left = p;
        p.right = prl;
        
        p.ht = NodeHeight(p);
        pr.ht = NodeHeight(pr);
        
        return pr;
    }
    
    static Node RLRotation(Node p) {
        Node pr = p.right;
        Node prl = pr.left;
        
        p.right = prl.left;
        pr.left = prl.right;
        prl.left = p;
        prl.right = pr;
        
        p.ht = NodeHeight(p);
        pr.ht = NodeHeight(pr);
        prl.ht = NodeHeight(prl);
        return prl;
    }

    static int BalanceFactor(Node p) {
        int hl, hr;
        if(p != null && p.left != null)
            hl = p.left.ht;
        else
            hl = -1;
        if(p != null && p.right != null)
            hr = p.right.ht;
        else
            hr = -1;
        return hl - hr;
    }

    static int NodeHeight(Node p) {
        int hl;
        int hr;
        if(p != null && p.left != null)
            hl = p.left.ht;
        else
            hl = -1;
        if(p != null && p.right != null)
               hr = p.right.ht;
        else
            hr = -1;
        if(hl > hr)
            return hl + 1;
        else
            return hr + 1;
    }
	static Node insert(Node p,int val)
    {
    	Node temp = null;
        if(p == null) {
            temp = new Node();
            temp.val = val;
            temp.ht = NodeHeight(temp);
            return temp;
        }
        if(val < p.val)
            p.left = insert(p.left, val);
        else if(val > p.val)
            p.right = insert(p.right, val);
        
        p.ht = NodeHeight(p);
        
        if(BalanceFactor(p) == 2 && BalanceFactor(p.left) == 1)
            return LLRotation(p);
        else if(BalanceFactor(p) == 2 && BalanceFactor(p.left) == -1)
            return LRRotation(p);
        else if(BalanceFactor(p) == -2 && BalanceFactor(p.right) == 1)
            return RLRotation(p);
        else if(BalanceFactor(p) == -2 && BalanceFactor(p.right) == -1)
            return RRRotation(p);
        return p;
    }
