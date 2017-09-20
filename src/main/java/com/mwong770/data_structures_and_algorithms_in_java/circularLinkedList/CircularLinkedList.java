package com.mwong770.data_structures_and_algorithms_in_java.circularLinkedList;

import java.util.Scanner;

public class CircularLinkedList
{
//	refers to last node of list
	private Node last;
	
//	constructor
	public CircularLinkedList()
	{
		last=null;
	}
	
//	creates a list
	public void createList()
	{
		int i,n,data;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the number of nodes : ");
		n = scan.nextInt();
		
		if(n==0)
			return;
		System.out.print("Enter the element to be inserted : ");
		data = scan.nextInt();
//		inserts first node
		insertInEmptyList(data);
		
		for(i=2; i<=n; i++)
		{
			System.out.print("Enter the element to be inserted : ");
			data = scan.nextInt();
//			inserts the rest of the nodes
			insertAtEnd(data);
		}
	}
	
//	displays list
	public void displayList()
	{
		Node p;
		
//		prints message if list is empty
		if(last==null)
		{
			System.out.println("List is empty\n");
			return;
		}
		
//		p refers to first node of list
		p=last.link;
		
//		using do while b/c initially p=last.link and we stop when p=last.link
//		if use while loop it'll never be exectuted
		do
		{
//			prints info value of each node
			System.out.print(p.info + " ");
			
//			moves p forward
			p=p.link;
			
//			p stopped when it refers to first node
		}while(p!=last.link);
		System.out.println();
	} /* ends displayList() */
	
//	inserts a new node in the beginning of a list
	public void insertInBeginning(int data)
	{
		Node temp=new Node(data);
		temp.link=last.link;
		last.link=temp;
	}
	
//	inserts a new node in an empty list
	public void insertInEmptyList(int data)
	{
		Node temp=new Node(data);
		last=temp;
		last.link=last;
	}
	
//	inserts a new node at the end of a list
	public void insertAtEnd(int data)
	{
		Node temp=new Node(data);
		temp.link=last.link;
		last.link=temp;
		last=temp;
	}
	
//	inserts a new node after a node containing value x
	public void insertAfter(int data, int x)
	{
		Node p=last.link;
//		finds reference to node containing value x
		do
		{
			if(p.info==x)
				break;
			p=p.link;
		}while(p!=last.link);
		
		if(p==last.link && p.info !=x)
			System.out.println(x + " not present in the list");
		else
		{
//			inserts new node after node referred to by p
			Node temp=new Node(data);
			temp.link=p.link;
			p.link=temp;
//			updates value of last
			if(p==last)
				last=temp;
		}
	}
	
//	deletes first node of the list
	public void deleteFirstNode()
	{
//		returns if list is empty
		if(last==null)
			return;
		
//		if list has only one node
		if(last.link==last)
		{
//			deletes node
			last=null;
			return;
		}
//		deletes first node of the list
		last.link=last.link.link;
	}
	
//	deletes last node of the list
	public void deleteLastNode()
	{
//		returns if list is empty
		if(last==null)
			return;
		
//		if list has only one node
		if(last.link==last)
		{
//			deletes node
			last=null;
			return;
		}
		Node p=last.link;
		
//		finds reference to second to last node of the list
		while(p.link!=last)
			p=p.link;
		
//		deletes last node
		p.link=last.link;
//		updates last if last node deleted
		last=p;
	}
	
//	deletes node with value of x
	public void deleteNode(int x)
	{
//		returns if list is empty
		if(last==null)
			return;
		
//		if only one node and it contains x
		if(last.link==last && last.info==x)
		{
//			deletes node
			last=null;
			return;
		}
		
//		if x in first node
		if(last.link.info==x)
		{
//			deletes node with x
			last.link=last.link.link;
			return;
		}
		
//		if x not in first node
		Node p=last.link;
		while(p.link!=last.link)
		{
//			finds link to predecessor of node that contains x
			if(p.link.info==x)
				break;
			p=p.link;
		}
		
		if(p.link==last.link)
			System.out.println(x + " not found in the list");
		else
		{
//			deletes node from list
			p.link=p.link.link;
//			updates last if last node deleted
			if(last.info==x)
				last=p;
		}
	}
		
//		adds list given as argument to end of list that calls this method
		public void concatenate(CircularLinkedList list)
		{
//			if first list is empty
			if(last==null)
			{
//				makes last of first list refer to last of list given as argument
				last=list.last;
				return;
			}
			
//			returns if list given as argument is empty
			if(list.last==null)
				return;
			
//			adds lists together
			Node p =last.link;
			last.link=list.last.link;
			list.last.link=p;
			last=list.last;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
