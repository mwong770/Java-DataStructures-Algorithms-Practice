package com.mwong770.data_structures_and_algorithms_in_java.priorityQueue;

public class Node
{
	public int priority;
	public int info;
	public Node link;
	
//	node of a linked list used to implement priority list
	public Node(int i, int pr)
	{
		info=i;
		priority=pr;
		link=null;
	}
}
