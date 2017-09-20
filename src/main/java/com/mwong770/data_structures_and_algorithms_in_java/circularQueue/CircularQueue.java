package com.mwong770.data_structures_and_algorithms_in_java.circularQueue;

import java.util.NoSuchElementException;

//implements a queue using a circular array
public class CircularQueue
{
	private int[] queueArray;
//	stores index value at front of queue
	private int front;
//	stores index value at rear of queue
	private int rear;
	
	public CircularQueue()
	{
		queueArray = new int[10];
//		initially queue is empty
		front = -1;
		rear = -1;
	}
	
//	maxSize is size of array
	public CircularQueue(int maxSize)
	{
		queueArray = new int[maxSize];
		front = -1;
		rear = -1;
	}
	
//	returns true if queue is empty
	public boolean isEmpty()
	{ 
		return (front==-1);
	}
	
//	returns true if queue is full
	public boolean isFull()
	{
	  return (front==0 && rear==queueArray.length-1 || (front==rear+1));
	}
	
//	inserts a new element into the queue
	public void insert(int x)
	{
//		returns if queue is full
		if(isFull())
		{
			System.out.println("Queue Overflow\n");
			return;
		}
		if(front==-1)
			front=0;
//		if rear = last index of array
		if(rear==queueArray.length-1)
			rear=0;
		else
//			increments rear
			rear=rear+1;
//		inserts new element in rear of array
		queueArray[rear]=x;
	}
	
//	deletes an element from the queue
	public int Delete()
	{
		if(isEmpty())
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		
//		removes element from front end
		int x=queueArray[front];
		
//		if queue has only one element
		if(front==rear)
		{
			front = -1;
			rear = -1;
		}
		
//		if front is equal to last index of array
		else if (front==queueArray.length-1)
			front=0;
		else
//			incremements front
			front=front+1;
		return x;
	}
	
//	returns the element of the front end of the queue
	public int peek()
	{
		if(isEmpty())	
		{
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		return queueArray[front];
	}
	
//	displays all of the elements of the queue
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return;
		}
		
		System.out.println("Queue is : ");
		
		int i=front;
		if(front<=rear)
		{
//			prints all elements from front to rear
			while(i<=rear)
				System.out.println(queueArray[i++] + " ");
		}
		else
		{
//			display all elements from front to last index of array
			while(i<=queueArray.length-1)
				System.out.println(queueArray[i++] + " ");
			i=0;
//			then display all the elements from index 0 to rear
			while(i<=rear)
				System.out.println(queueArray[i++] + " ");
		}
		System.out.println();
	}
	
//	returns the number of elements in the queue
	public int size()
	{
		if(isEmpty())
			return 0;
		if(isFull())
			return queueArray.length;
		
		int i=front;
		int sz=0;
		if(front<=rear)
			while(i<=rear)
			{
				sz++;
				i++;
			}
		else
		{
			while(i<=queueArray.length-1)
			{
				sz++;
				i++;
			}
			i=0;
			while(i<=rear)
			{
				sz++;
				i++;
			}
		}
		return sz;
	}
	
	
	
}