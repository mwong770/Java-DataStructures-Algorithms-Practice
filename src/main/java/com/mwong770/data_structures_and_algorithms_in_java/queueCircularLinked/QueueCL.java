package com.mwong770.data_structures_and_algorithms_in_java.queueCircularLinked;

import java.util.NoSuchElementException;

import com.mwong770.data_structures_and_algorithms_in_java.circularLinkedList.Node;

//implements queue using a circular linked list
public class QueueCL
{
//	refers to the last node of the list
	private Node rear;
	
	public QueueCL()
	{
//		queue initially empty
		rear=null;
	}
	
//	returns true if the queue is empty
	public boolean isEmpty()	
	{
		return(rear==null);
	}
	
//	inserts a new element into the queue at the rear end
	public void insert(int x)
	{
		Node temp = new Node(x);
		
		if(isEmpty())
		{
			rear=temp;
			rear.link=rear;
		}
		else
			{
				temp.link=rear.link;
				rear.link=temp;
				rear=temp;
			}
	}
		
//	deletes an element from the front end
	public int Delete()
		{
		if(isEmpty())
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		Node temp;
			
//		if only one element
		if(rear.link==rear)
		{
			temp=rear;
			rear=null;
		}
		else
		{
			temp=rear.link;
			rear.link=temp.link;
		}
		return temp.info;
	}
		
//	returns the element of front end
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		return rear.link.info;
	}
	
//	displays all of the elements in the queue
	public void display()
	{
		if(isEmpty()) 
		{
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Queue is : ");
		Node p=rear.link;
		do
		{
			System.out.print(p.info + " ");
			p=p.link;
		}while(p!=rear.link);
		System.out.println();
		
	}
	
//	displays the size of the queue
	public int size()
	{
		if(isEmpty()) 
			return 0;
		int s=0;
		Node p=rear.link;
		do
		{
			s++;
			p=p.link;
		}while(p!=rear.link);
		return s;
	}
} /* ends class */










