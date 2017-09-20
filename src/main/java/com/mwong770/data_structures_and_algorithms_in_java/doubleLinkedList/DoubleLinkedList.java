package com.mwong770.data_structures_and_algorithms_in_java.doubleLinkedList;

import java.util.Scanner;

public class DoubleLinkedList
{
//	refers to first node of list
	private Node start;
	
//	constructor
	public DoubleLinkedList()
	{
		start=null;
	}
	
	public void displayList()
	{
		Node p;
		
//		return if list empty
		if(start==null)
		{
			System.out.println("List is empty");
			return;
		}
		
//		traverse list and print all contents of list
		p=start;
		System.out.println("List is :\n");
		while(p!=null)
		{
			System.out.print(p.info + " ");
			p=p.next;
		}
		System.out.println();
		
	} /* ends displayList() */
	
//	inserts new node in beginning of list
	public void insertInBeginning(int data)
	{
		Node temp = new Node(data);
		temp.next=start;
		start.prev=temp;
		start=temp;
	}
	
//	inserts new node in empty list
	public void insertInEmptyList(int data)
	{
		Node temp = new Node(data);
		start=temp;
	}
	
//	inserts a new node at end of list
	public void insertAtEnd(int data)
	{
		Node temp = new Node(data);
		
		Node p=start;
		
//		finds reference to the last node of the list
		while(p.next!=null)
			p=p.next;
		
//		inserts new node
		p.next=temp;
		temp.prev=p;
	}
	
	
//	creates a list
	public void createList()
	{
		int i,n,data;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the number of nodes : ");
		n=scan.nextInt();
		
		if(n==0)
			return;
		
		System.out.println("Enter the first element to be inserted : ");
		data = scan.nextInt();
		
//		creates first node
		insertInEmptyList(data);
		
		for(i=2; i<=n; i++)
		{
			System.out.println("Enter the next element to be inserted : ");
			data=scan.nextInt();
			
//			creates rest of nodes
			insertAtEnd(data);
		}
	} /* ends createList() */
	
//	inserts a new node after node containing x
	public void insertAfter(int data, int x)
	{
		Node temp=new Node(data);
		Node p=start;
		
//		finds reference to node containing x
		while(p!=null)
		{
			if(p.info==x)
				break;
			p=p.next;
		}
		
//		if p null, print message
		if(p==null)
			System.out.println(x + " not present in the list");
		else
		{
//			inserts new node after node referred to by p
			temp.prev =p;
			temp.next=p.next;
			if(p.next != null)
				p.next.prev=temp; /* should not be done when p refers to last node or will get error */
			p.next=temp;
		}
	} /* ends insertAfter() */
	
//	inserts a new node before node containing x
	public void insertBefore(int data, int x)
	{
//		returns if list empty
		if(start==null)
		{
			System.out.println("List is empty");
			return;
		}
		
//		inserts node at beginning of list
		if(start.info==x)
		{
			Node temp=new Node(data);
			temp.next=start;
			start.prev=temp;
			start=temp;
			return;
		}
		
		
//		finds reference to node containing x
		Node p=start;
		while(p!=null)
		{
			if(p.info==x)
				break;
			p=p.next;
		}
		
		if(p==null)
			System.out.println(x + " not present in the list");
		else
		{
//			insert new node before node referred to by p
			Node temp=new Node(data);
			temp.prev=p.prev;
			temp.next=p;
			p.prev.next=temp;
			temp.next=p;
			p.prev.next=temp;
			p.prev=temp;
		}
	} /* ends insertBefore() */
	
//	deletes first node of list
	public void deleteFirstNode()
	{
//		returns if list is empty
		if(start==null) 
			return;
		
//		if list has only one node
		if(start.next==null) 
		{
//			deletes node
			start=null;
			return;
		}
		
//		deletes first node
		start=start.next;
		start.prev=null;
	}
	
//	deletes the last node of the list
	public void deleteLastNode()
	{
//		returns if list is empty
		if(start==null)
			return;
		
//		if list has only one node
		if(start.next==null)
		{
//			deletes node
			start=null;
			return;
		}
		
//		finds reference to the last node of the list
		Node p=start;
		while(p.next!=null)
			p=p.next;
		
//		deletes node
		p.prev.next=null;
	}
	
//	deletes node that contains x
	public void deleteNode(int x)
	{
//		returns if list is empty
		if(start==null)
			return;
		
//		if list has only one node
		if(start.next==null)
		{
			if(start.info==x)
//				deletes node if contains x
				start=null;
			else
				System.out.println(x + " not found");
			return;
		}
		
//		if x present in first node
		if(start.info==x)
		{
//			deletes first node
			start=start.next;
			start.prev=null;
			return;
		}
		
//		finds reference to node containing x
		Node p=start.next;
		while(p.next !=null)
		{
			if(p.info==x)
				break;
			p=p.next;
		}
		
//		if x in node between the list
		if(p.next!=null)
		{
//			deletes the node containing x
			p.prev.next=p.next;
			p.next.prev=p.prev;
		}
		else
		{
//			if p refers to the last node
			if(p.info==x)
//				deletes last node
				p.prev.next=null;
			else
				System.out.println(x + " not found");
		}
	} /* ends deleteNode() */
	
//	reverses a list
	public void reverseList()
	{
//		returns if list is empty
		if(start==null)
			return;
		
		Node p1=start;
		Node p2=p1.next;
		p1.next=null;
		p1.prev=p2;
		while(p2!=null)
		{
			p2.prev=p2.next;
			p2.next=p1;
			p1=p2;
			p2=p2.prev;
		}
		start=p1;
	} /* ends reverseList() */
	
	
} /* ends class */