package com.mwong770.data_structures_and_algorithms_in_java.circularLinkedList;

public class ConcatenateMain
{
	public static void main(String[] args)
	{
		CircularLinkedList List1 = new CircularLinkedList();
		CircularLinkedList List2 = new CircularLinkedList();
		
		System.out.println("Enter first list :- ");
		List1.createList();
		System.out.println("Enter second list :- ");
		List2.createList();
		
		System.out.print("First ");
		List1.displayList();
		System.out.print("Second ");
		List2.displayList();
		
		List1.concatenate(List2);
		System.out.print("First ");
		List1.displayList();
	}
}