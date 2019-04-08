
//a node of a BST and class declaration.
public class bstree{
    node root;
    static class node{
        int num;
        node left;
        node right;
        node(int n) { this.num = n; }
    }

//find the predecessor of node with value as val
public static node predecessor(node n,int val)
{
	if(n == null)
		return n;
	if(n.num == val)
	{
		if(n.left != null)
		{
			node temp = n.left;
			while(temp.right != null)
				{
					temp = temp.right;
				}
			return temp;
			
		}
	}
	
	if(n.num < val)
		return predecessor(n.right,val);
	
	if(n.num > val)
		return predecessor(n.left,val);
	
	return n;
}

//find the successor of a node with value as val.
public static node successor(node n,int val)
{
	if(n == null)
		return n;
	if(n.num == val)
	{
		if(n.right != null)
		{
			node temp = n.right;
			while(temp.left != null)
				{
					temp = temp.left;
				}
			return temp;
			
		}
	}
	
	if(n.num < val)
		return successor(n.right,val);
	
	if(n.num > val)
		return successor(n.left,val);
	
	return n;
}
 
//BST insert function with logic: left is always strictly smaller than root and right is strictly greater than root
public static bstree insertin(bstree bst,node n, int val)
{
	if(n.num == val )
		return bst;
	
		
	if(n.num < val) 
	{
		if(n.right == null)
		{
			node n1 = new node(val);
			n.right = n1;
			return bst;
		}
		return insertin(bst,n.right,val);
	}
	
	else if(n.num > val)
	{
		if(n.left ==  null)
		{
			node n1 = new node(val);
			n.left = n1;
			return bst;
		}
		return insertin(bst,n.left,val);
	}
	
	System.out.print("node doesn't exist");
	return bst;
	}

//Parent check and use it for deleting nodes
public static node parentof(node root,node n)
{
	if(root.num == n.num)
		return root;
	
	if(root.left != null && root.left.num == n.num || root.right != null && root.right.num == n.num)
		return root;
	
	if(root.num > n.num)
		return parentof(root.left,n);
	if(root.num < n.num)
		return parentof(root.right,n);
	
	else
	{
		System.out.print("not found");
		return root;
	}
}
//traversal function 
public static void inordertrav(node n)
{
	if(n == null)
		return;
		
	inordertrav(n.left);
	System.out.print(n.num + "->");
	inordertrav(n.right);
	
}

//delete function
public static bstree deletein(bstree bst,node n, int val)
{
	if(n == null)
		System.out.print("empty tree or value not found");
	
	if(n.num == val)
	{
		node temp = predecessor(n,val);
		if(temp.num == val)
		{
			if(temp.left == null && temp.right == null)
				{
					node np = parentof(bst.root,temp);
					if(np.left != null && np.left.num == temp.num)
						np.left = null;
					else
						np.right = null;
					return bst;
				}
				
			if(temp.left == null && temp.right != null) //as we are already taking predecessor
			{
				node n2 = successor(bst.root,val);
				int tp = n2.num;
				node np = parentof(bst.root,n2);
				if(np.left != null && np.left.num == n2.num)
					np.left = null;
				else
					np.right = null;
				n.num = tp;
				return bst;
				
			}
			
		}
		else
		{
			int tp = temp.num;
			node np = parentof(bst.root,temp);
			if(np.left != null && np.left.num == tp)
				np.left = null;
			else
				np.right = null;
			n.num = tp;
			return bst;
		}
	}
	
	if(n.num > val)
		{
			return deletein(bst,n.left,val);
		}
	if(n.num < val)
		{
			return deletein(bst,n.right,val);
		}
	
	else
		
		{
			System.out.print("node doesn't exist");
			return bst;
		}
		
	
}

public static void main(String[] args)
{
	bstree bst = new bstree();
	node n = new node(40);
	bst.root = n;
	bst = insertin(bst,bst.root,20);
	bst = insertin(bst,bst.root,10);
	bst = insertin(bst,bst.root,30);
	bst = insertin(bst,bst.root,1);
	bst = insertin(bst,bst.root,8);
	bst = insertin(bst,bst.root,5);
	bst = insertin(bst,bst.root,3);
	bst = insertin(bst,bst.root,50);
	bst = insertin(bst,bst.root,45);
	bst = insertin(bst,bst.root,60);
	bst = insertin(bst,bst.root,100);
	bst = insertin(bst,bst.root,55);
	bst = insertin(bst,bst.root,200);
	bst = insertin(bst,bst.root,150);
	bst = insertin(bst,bst.root,95);
	
	inordertrav(bst.root); //first pass
	System.out.print("\n");
	deletein(bst,bst.root,1); //leaf node deleted
	inordertrav(bst.root);
	System.out.print("\n");
	deletein(bst,bst.root,45); //node with a subtree deleted
	inordertrav(bst.root);
	System.out.print("\n");
	
}

}    
