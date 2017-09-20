package com.mwong770.data_structures_and_algorithms_in_java.doubleLinkedList;

public class Node
{
//	refers to nodes before and after, and info stored in node
	public Node prev;
	public int info;
	public Node next;
	
//	constructor
	public Node(int i)
	{
		info=i;
		prev=null;
		next=null;
	}
}