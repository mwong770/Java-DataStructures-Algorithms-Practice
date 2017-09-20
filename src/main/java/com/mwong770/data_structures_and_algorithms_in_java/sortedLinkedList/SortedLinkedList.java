package com.mwong770.data_structures_and_algorithms_in_java.sortedLinkedList;

import java.util.Scanner;

import com.mwong770.data_structures_and_algorithms_in_java.circularLinkedList.Node;

public class SortedLinkedList
{
	private Node start;
	
	public SortedLinkedList()
	{
		start=null;
	}
	
//	inserts a new node in the list
	public void insertInOrder(int data)
	{
//		allocates a new node
		Node temp=new Node(data);
		
//		if list empty or new node to be inserted is before first node
		if(start==null || data< start.info)
		{
//			inserts new node at beginning of list
			temp.link=start;
			start=temp;
			return;
		}
		
//		finds reference to the node after which the new node has to be inserted
		Node p=start;
		while(p.link!=null && p.link.info <= data)
			p=p.link;
		
//		inserts new node
		temp.link=p.link;
		p.link=temp;
	}
	
	public void createList()
	{
		int i, n, data;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the number of nodes : ");
		n = scan.nextInt();
		
		if(n==0)
			return;
		
		for(i=1; i<=n; i++)
		{
			System.out.print("Enter the element to be inserted : ");
			data = scan.nextInt();
			insertInOrder(data);
		}
	}
	
	public void search(int x)
	{
//		returns message if list is empty
		if(start==null)
		{
			System.out.println("List is empty");
			return;
		}
		
		Node p=start;
		int position=1;
		while(p!=null && p.info<=x)
		{
			if(p.info==x)
				break;
			position++;
			p=p.link;
		}
		if(p==null || p.info!=x)
			System.out.println(x + " not found in list");
		else
			System.out.println(x + " is at position " + position);
	}
	
	public void displayList()
	{
		Node p;
		if (start == null)
		{
			System.out.println("List is empty");
			return;
		}
		System.out.print("List is :    ");
		p=start;
		
//		traverses the linked list and prints info in each node
		while (p != null)
		{
//			prints contents of individual node
			System.out.print(p.info + " ");
			
//			makes p refer to the next node
			p=p.link;
		}
		System.out.println();
		
	} /* ends displayList() */
	
	
	
	
	
	
	
	
	
	
}