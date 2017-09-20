package com.mwong770.data_structures_and_algorithms_in_java.stackArray;

import java.util.EmptyStackException;

public class StackA
{
	private int[] stackArray;
	
//	stores index of top most element of stack
	private int top;
	
	public StackA()
	{
//		creates 10 element array
		stackArray = new int[10];
		
//		stack initially empty
		top=-1;
	}
	
//	maxSize is size to be allocated to array
	public StackA(int maxSize)
	{
		stackArray = new int[maxSize];
		top=-1;
	}
	
//	returns the number of elements in the stack
	public int size()
	{
		return top+1;
	}
	
//	returns true if stack is empty
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
//	returns true if the stack is full
	public boolean isFull()
	{
		return (top==stackArray.length-1);
	}
	
//	inserts a new element in the stack
	public void push(int x)
	{
//		returns if stack is full
		if(isFull())
		{
			System.out.println("Stack Overflow");
			return;
		}
//		adds one to top
		top=top+1;
		
//		inserts element at index top of array
		stackArray[top]=x;
	}
	
//	deletes the top most element of the stack
	public int pop()
	{
		int x;
		
//		throws exception if stack is empty
		if(isEmpty())
		{
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		
//		grabs the top most element
		x=stackArray[top];
		
//		decrements top
		top=top-1;
		
//		returns top most element
		return x;
	}
	
//	returns the top most element of the stack without removing it
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		return stackArray[top];
	}
	
//	displays all of the elements of the stack
	public void display()
	{
		int i;
		
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return;
		}
		System.out.println("Stack is : ");
		for(i=top; i>=0; i--)
			System.out.println(stackArray[i] + " ");
		System.out.println();
	}
	
	
} /* ends class */