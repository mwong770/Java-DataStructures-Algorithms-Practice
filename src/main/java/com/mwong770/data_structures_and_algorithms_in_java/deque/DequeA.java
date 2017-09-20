package com.mwong770.data_structures_and_algorithms_in_java.deque;

import java.util.NoSuchElementException;

//inplements a deque using a circular array
public class DequeA
{
	private int[] queueArray;
	
//	stores the index value at front
	private int front;
	
//	stores the index value at rear
	private int rear;
	
	public DequeA()
	{
		queueArray = new int[10];
		front =-1;
		rear=-1;
	}
	
	public DequeA(int maxSize)
	{
		queueArray = new int[maxSize];
		front = -1;
		rear =-1;
	}
	
//	inserts a new element at the front end
	public void insertFront(int x)
	{
		if(isFull())
		{
			System.out.println("Queue Overflow");
			return;
		}
		if(front==-1)
		{
			front =0;
			rear=0;
		}
		else if (front==0)
			front = queueArray.length-1;
		else
			front = front-1;
		queueArray[front] = x;
	}
	
//	inserts a new element at the rear end of the deque
	public void insertRear(int x)
	{
		if(isFull())
		{
			System.out.println("Queue Overflow");
			return;
		}
		
		if(front==-1)
			front = 0;
		if(rear==queueArray.length-1)
			rear =0;
		else
			rear=rear+1;
		queueArray[rear] =x;
	}
	
//	deletes an element at front end of the deque
	public int deleteFront()
	{
		int x;
		if(isEmpty())
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		x=queueArray[front];
		
//		if only one element
		if(front==rear)
		{
			front=-1;
			rear=-1;
		}
		else if(front==queueArray.length-1)
			front=0;
		else
			front=front+1;
		return x;
	}
	
//	deletes an element at the rear end of the deque
	public int deleteRear()
	{
		int x;
		if(isEmpty())
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		x=queueArray[rear];
		
//		only one element 
		if(front==rear)
		{
			front=-1;
			rear=-1;
		}
		else if(rear==0)
			rear=queueArray.length-1;
		else
			rear=rear-1;
		return x;
	}
	
//	returns true if the deque is full
	public boolean isFull()
	{
		return ((front==0 && rear==queueArray.length-1) || (front==rear+1));
	}
	
//	returns true if the deque is empty
	public boolean isEmpty()
	{
		return (front==-1);
	}
	
//	displays all of the elements of the deck
	public void display()
	{
		int i;
		
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return;
		}
		
		System.out.println("Queue is : ");
		i=front;
		if(front<=rear)
		{
			while(i<=rear)
				System.out.print(queueArray[i++] + " ");
		}
		else
		{
			while(i<=queueArray.length-1)
				System.out.print(queueArray[i++] + " ");
			i=0;
			while(i<=rear)
				System.out.print(queueArray[i++] + " ");
		}
		System.out.println();
	}
	
	
} /* ends class */