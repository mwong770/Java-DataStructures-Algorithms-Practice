package com.mwong770.data_structures_and_algorithms_in_java.priorityQueue;

import java.util.NoSuchElementException;

//implements priority queue using the single linked list
public class PriorityQueueL
{
	private Node front;
	
	public PriorityQueueL()
	{
//		initially the queue is empty
		front=null;
	}
	
//	inserts an element into the queue based on its priority
	public void insert(int element, int elementPriority)
	{
		Node temp, p;
		
		temp= new Node(element, elementPriority);

//		queue is empty or element to be added has priority more than first element
		if(isEmpty() || elementPriority < front.priority)
		{
			temp.link = front;
			front=temp;
		}
		else
		{
			p=front;
			while(p.link!=null && p.link.priority<=elementPriority)
				p=p.link;
			temp.link=p.link;
			p.link=temp;
		}
	}
	
//	deletes the first node of the list
	public int Delete()
	{
		int element;
		if(isEmpty())
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		else
		{
			element=front.info;
			front=front.link;
		}
		return element;
	}
	
//	returns true if queue is empty
	public boolean isEmpty()	
	{
		return (front==null);
	}
	
//	displays all of the elements of the list
	public void display()
	{
		Node p=front;
		if(isEmpty())
			System.out.println("Queue is empty\n");
		else
		{
			System.out.println("Queue is : ");
			System.out.println("Element Priority");
			while(p!=null)
			{
				System.out.println(p.info + "       " + p.priority);
				p=p.link;
			}
		}
		System.out.println("");
	}
	
} /* ends class */