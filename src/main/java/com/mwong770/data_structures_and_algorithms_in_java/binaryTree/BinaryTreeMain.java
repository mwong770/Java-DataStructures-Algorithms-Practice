package com.mwong770.data_structures_and_algorithms_in_java.binaryTree;

public class BinaryTreeMain
{
	public static void main(String[] args)
	{
//		creates a binary tree object
		BinaryTree bt = new BinaryTree();
		
		bt.createTree();
		
		bt.display();
		System.out.println();
		
		System.out.println("Preorder : ");
		bt.preorder();
		System.out.println("");
		
		System.out.println("Inorder : ");
		bt.inorder();
		System.out.println();
		
		System.out.println("Postorder : ");
		bt.postorder();
		System.out.println();
		
		System.out.println("Level order : ");
//		bt.levelOrder();
		System.out.println();
		
		System.out.println("Height of tree is " + bt.height());
	}
}