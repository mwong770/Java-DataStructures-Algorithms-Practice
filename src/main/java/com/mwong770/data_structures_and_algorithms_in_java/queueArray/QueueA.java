package com.mwong770.data_structures_and_algorithms_in_java.queueArray;

import java.util.NoSuchElementException;

//implements a queue using array
public class QueueA
{
	private int[] queueArray;
//	stores index value at front
	private int front;
//	stores index value at rear 
	private int rear;
	
	public QueueA()
	{
		queueArray = new int[10];
//		initially queue is empty
		front=-1;
		rear=-1;
	}
	
//	maxSize denotes the size of the array
	public QueueA(int maxSize)
	{
		queueArray = new int[maxSize];
		front=-1;
		rear=-1;
	}
	
//	returns true if queue is empty
	public boolean isEmpty()
	{
		return (front==-1 || front==rear+1);
	}
	
//	returns true if queue is full
	public boolean isFull()
	{
		return (rear == queueArray.length-1);
	}
	
//	returns the number of elements in the queue
	public int size()
	{
		if(isEmpty())
			return 0;
		else
			return (rear-front)+1;
	}
	
//	inserts a new element at the rear of the array
	public void insert(int x)
	{
		if(isFull())
		{
			System.out.println("Queue Overflow\n");
			return;
		}
		if(front==-1)
			front=0;
		rear=rear+1;
		queueArray[rear]=x;
	}
	
//	deletes and element from the front end of queue
	public int Delete()
	{
		int x;
		if(isEmpty())
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
//		grabs value at front end
		x=queueArray[front];
		
//		increments value of front
		front=front+1;
		
//		returns value at front end
		return x;
	}
	
//	returns element at front end without removing it from queue
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue Underflow\n");
			throw new NoSuchElementException();
		}
		return queueArray[front];
	}
	
//	displays all the elements of the queue
	public void display()
	{
		int i;
		
		if(isEmpty())
		{
			System.out.println("Queue is empty\n");
			return;
		}
		
		System.out.println("QUeue is :\n\n");
		for(i=front; i<=rear; i++)
			System.out.print(queueArray[i] + " ");
		
		System.out.println();
	}
	
} /* ends class */