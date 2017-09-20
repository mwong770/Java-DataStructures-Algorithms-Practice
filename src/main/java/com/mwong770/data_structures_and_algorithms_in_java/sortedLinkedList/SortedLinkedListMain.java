package com.mwong770.data_structures_and_algorithms_in_java.sortedLinkedList;

import java.util.Scanner;

public class SortedLinkedListMain
{
	public static void main(String[] args)
	{
		int choice, data;
		
		Scanner scan = new Scanner(System.in);
		
		SortedLinkedList List = new SortedLinkedList();
		List.createList();
		
		while(true)
		{
			System.out.println("1. Display List");
			System.out.println("2. Insert a new node");
			System.out.println("3. Search");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			choice = scan.nextInt();
			
			if(choice==4)
				break;
			
			switch(choice)
			{
				case 1: 
					List.displayList();
					break;
				case 2: 
					System.out.println("Enter the element to be inserted : ");
					data = scan.nextInt();
					List.insertInOrder(data);
					break;
				case 3: 
					System.out.println("Enter the element to be searched : ");
					data = scan.nextInt();
					List.search(data);
					break;
				default:
					System.out.println("Wrong choice");
			} /* ends switch */
		}
	} /* ends main() */
} /* ends class */