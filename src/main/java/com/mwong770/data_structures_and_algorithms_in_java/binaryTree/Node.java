package com.mwong770.data_structures_and_algorithms_in_java.binaryTree;

//represents node of a binary tree
public class Node
{
	Node lchild;
	char info;
	Node rchild;
	
	public Node (char ch)
	{
		info=ch;
		lchild=null;
		rchild=null;
	}
}