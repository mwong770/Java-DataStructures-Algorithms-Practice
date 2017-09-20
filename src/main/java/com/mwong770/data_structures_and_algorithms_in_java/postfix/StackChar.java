package com.mwong770.data_structures_and_algorithms_in_java.postfix;

import java.util.EmptyStackException;

//implements a stack using a character array
public class StackChar
{
	private char[] stackArray;
	private int top;
	
	public StackChar()
	{
		stackArray = new char[10];
		top=-1;
	}
	
	public StackChar(int maxSize)
	{
		stackArray = new char[maxSize];
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
	public void push(char x)
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
	public char pop()
	{
		char x;
		
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
	public char peek()
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