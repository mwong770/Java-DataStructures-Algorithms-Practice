package com.mwong770.data_structures_and_algorithms_in_java.stackLinked;

import java.util.EmptyStackException;

import com.mwong770.data_structures_and_algorithms_in_java.circularLinkedList.Node;

//implements a stack using linked list
public class StackL
{
//	refers to first node of the list
	private Node top;
	
	
//	constructor
	public StackL()
	{
//		initially stack is empty
		top=null;
	}
	
//	returns the number of elements in the stack
	public int size()
	{
		int s=0;
		
//		traverses link link list
		Node p=top;
		while(p!=null)
		{
			p=p.link;
//			counts nodes
			s++;
		}
		return s;
	}
	
//	pushes a new element in the stack
	public void push(int x)
	{
//		a new node inserted at beginning of linked list
		Node temp = new Node(x);
		temp.link=top;
		top=temp;
	}
	
//	removes an element from the stack
	public int pop()
	{
		int x;
		
//		prints message if stack empty
		if(isEmpty())
		{
			System.out.println("Stack Underflow\n");
			throw new EmptyStackException();
		}
		
//		removes node from beginning of the linked list
		x=top.info;
		top=top.link;
		return x;
	}
	
//	returns the top most element of the stack
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack Underflow\n");
			throw new EmptyStackException();
		}
//		returns info part of first node
		return top.info;
	}
	
//	returns true if the stack is empty
	public boolean isEmpty()
	{
		return (top==null);
	}
	
//	displays all of the elements of the stack
	public void display()
	{
		Node p=top;
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("Stack is : ");
		while(p!=null)
		{
			System.out.println(p.info + " ");
			p=p.link;
		}
		System.out.println();
	}
	
	
} /* ends class */
