package com.mwong770.data_structures_and_algorithms_in_java.headerList;

import java.util.Scanner;

public class HeaderList
{
//	refers to header node
	private Node head;
	
//	constructor
	public HeaderList()
	{
//		makes head refer to header node
		head=new Node(0);
	}
	
//	creates a list
	public void createList()
	{
		int i, n, data;
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter the number of nodes : ");
		n=scan.nextInt();
		
		for(i=1; i<=n; i++)
		{
			System.out.println("Enter the element to be inserted : ");
			data = scan.nextInt();
			insertAtEnd(data);
		}
	}
	
//	displays a list
	public void displayList()
	{
//		prints message if link is empty
		if(head.link==null)
		{
			System.out.println("List is empty\n");
			return;
		}
		
//		traverse list and print contents of list
		Node p=head.link;
		System.out.println("List is :\n");
		while(p!=null)
		{
			System.out.println(p.info + " ");
			p=p.link;
		}
		System.out.println();
	}
	
//	inserts a new node at the end of the list
	public void insertAtEnd(int data)
	{
		Node temp = new Node(data);
		
		Node p=head;
		while(p.link!=null)
			p=p.link;
		
		p.link=temp;
		temp.link=null;
	}

//	inserts a new node before node containing x
	public void insertBefore(int data, int x)
	{
		Node temp;
		
//		find pointer to predecessor of node containing x
		Node p=head;
		while(p.link!=null)
		{
			if(p.link.info==x)
				break;
			p=p.link;
		}
		
		if(p.link==null)
			System.out.println(x + " not present in the list");
		else
		{
			temp=new Node(data);
			temp.link=p.link;
			p.link=temp;
		}
	}
	
//	inserts a new node at position k in the list
	public void insertAtPosition(int data, int k)
	{
		Node temp;
		int i;
		
		Node p=head;
		for(i=1; i<=k-1 && p!=null; i++)
			p=p.link;
		
		if(p==null)
			System.out.println("You can insert only up to " + (i-1) + "th position\n\n");
		else
		{
			temp=new Node(data);
			temp.link=p.link;
			p.link=temp;
		}
	}
	
	public void deleteNode(int data)
	{
		Node p=head;
		while(p.link!=null)
		{
			if(p.link.info==data)
				break;
			p=p.link;
		}
		
		if(p.link==null)
			System.out.println(data + "Element %d not found");
		else
			p.link = p.link.link;
	}
	
	
	
	
	
	
	
	
}