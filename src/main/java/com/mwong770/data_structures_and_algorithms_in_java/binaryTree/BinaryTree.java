package com.mwong770.data_structures_and_algorithms_in_java.binaryTree;

//implements a binary tree
public class BinaryTree
{
	private Node root;
	
	public BinaryTree()
	{
//		initially the tree is empty
		root=null;
	}
	
//	displays the binary tree from left to right
	public void display()
	{
		display(root, 0);
		System.out.println();
	}
	
	private void display(Node p, int level)
	{
		int i;
		if(p==null)
			return;
		
		display(p.rchild, level+1);
		System.out.println();
		
		for(i=0; i<level; i++)
			System.out.print("      ");
		System.out.print(p.info);
		
		display(p.lchild, level+1);
	}
	
	public void preorder()
	{
		preorder(root);
		System.out.println();
	}
	
	private void preorder(Node p)
	{
		if(p==null)
			return;
		System.out.print(p.info + " ");
		preorder(p.lchild);
		preorder(p.rchild);
	}
	
	public void inorder()
	{
		inorder(root);
		System.out.println();
	}
	
	private void inorder(Node p)
	{
		if(p==null)
			return;
		inorder(p.lchild);
		System.out.print(p.info + " ");
		inorder(p.rchild);
	}
	
	public void postorder()
	{
		postorder(root);
		System.out.println();
	}
	
	private void postorder(Node p)
	{
		if(p==null)
			return;
		postorder(p.lchild);
		postorder(p.rchild);
		System.out.print(p.info + " ");
	}
	
//	public void levelOrder()
//	{
//		Node p=root;
//		
//		if(p==null)
//		{
//			System.out.println("Tree is empty");
//			return;
//		}
//
//		QueueA q = new QueueA(20);
//		
//		q.insert(p);
//		while(1q.isEmpty())
//		{
//			p.q.Delete();
//			System.out.print(p.info + " ");
//			if(p.lchild!=null)
//				q.insert(p.lchild);
//			if(p.rchild!=null)
//				q.insert(p.rchild);
//		}
//		System.out.println();
//	}
	
//	returns height of a binary tree
	public int height()
	{
		return height(root);
	}
	
	private int height(Node p)
	{
		int hL, hR;
		
		if(p==null)
			return 0;
		
		hL=height(p.lchild);
		hR=height(p.rchild);
		
		if(hL > hR)
			return 1+hL;
		else
			return 1+hR;
	}
	
//	creates a binary tree
	public void createTree()
	{
		root = new Node('P');
		root.lchild = new Node('Q');
		root.rchild = new Node('R');
		root.lchild.lchild = new Node('A');
		root.lchild.rchild = new Node('B');
		root.rchild.lchild = new Node('X');
	}
}