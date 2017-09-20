package com.mwong770.data_structures_and_algorithms_in_java.parenthesesCheck;

import java.util.EmptyStackException;

//implements a stack using a character array
public class StackA
{
	private char[] stackArray;
	private int top;
	
	public StackA()
	{
		stackArray = new char[10];
		top = -1;
	}
	
	public StackA(int maxSize)
	{
		stackArray = new char[maxSize];
		top=-1;
	}
	
//	returns true if stack is empty
	public boolean isEmpty()
	{
		return (top==-1);
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
		
//		returns the top most element
		return x;
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

} /*  ends class */