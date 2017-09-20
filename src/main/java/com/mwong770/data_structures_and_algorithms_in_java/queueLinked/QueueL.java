package com.mwong770.data_structures_and_algorithms_in_java.queueLinked;

import java.util.NoSuchElementException;

import com.mwong770.data_structures_and_algorithms_in_java.circularLinkedList.Node;

public class QueueL
{
//	refers to first node of list
	private Node front;
	
//	refers to last node of the list
	private Node rear;
	
	public QueueL()
	{
//		initially the list is empty
		front = null;
		rear = null;
	}
	
//	returns the number of elements in the queue
	public int size() {
		int s=0;
		Node p=front;
//		traverses list
		while(p!=null)
		{
//			counts number of nodes
			s++;
			p=p.link;
		}
		return s;
	}
	
//	inserts a new element into the queue at the rear end
	public void insert(int x)
	{
		Node temp;
		temp = new Node(x);
		
//		if queue is empty
		if(front==null)
			front=temp;
		else
			rear.link=temp;
		rear=temp;
	}
	
//	deletes an element from the front end of the queue
	public int Delete()
	{
		int x;
		if(isEmpty())
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		x=front.info;
		front=front.link;
		return x;
	}
	
//	returns the element at the front end without deleting it
	public int peek()
	{
		if(isEmpty())	
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
//		info part of first node is returned
		return front.info;
	}
	
//	returns true if the queue is empty
	public boolean isEmpty()
	{
		return (front==null);
	}
	
//	diplays all the elements of the queue
	public void display()
	{
		Node p=front;
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return;
		}
		
		System.out.println("Queue is : ");
		while(p!=null)
		{
			System.out.print(p.info + " ");
			p=p.link;
		}
		System.out.println();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
} /* ends class */