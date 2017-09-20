package com.mwong770.data_structures_and_algorithms_in_java.singleLinkedList;

public class Node
{
	public int info;
	public Node link;
	
//	constructor
	public Node (int i)
	{
		
//		info stores data in the list
		info=i;
		
//		link references the next node
		link=null;
	}
}