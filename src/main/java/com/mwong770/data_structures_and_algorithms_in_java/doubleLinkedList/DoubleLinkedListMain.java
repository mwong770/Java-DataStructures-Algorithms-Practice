package com.mwong770.data_structures_and_algorithms_in_java.doubleLinkedList;

import java.util.Scanner;

public class DoubleLinkedListMain
{
	public static void main(String[] args)
	{
		int choice, data, x;
		Scanner scan = new Scanner(System.in);
		
//		declares DoubleLinkedList object
		DoubleLinkedList List = new DoubleLinkedList();
		
//		creates a list
		List.createList();
		
		while(true)
		{
			System.out.println("1. Display List");
			System.out.println("2. Insert in empty list");
			System.out.println("3. Insert a node in beginning of list");
			System.out.println("4. Insert a node at end of list");
			System.out.println("5. Insert a node after a specified node");
			System.out.println("6. Insert a node before a specified node");
			System.out.println("7. Delete first node");
			System.out.println("8. Delete last node");
			System.out.println("9. Delete any node");
			System.out.println("10. Reverse the list");
			System.out.println("11. Quit");
			System.out.println("Enter your choice : ");
			choice = scan.nextInt();
			
			if(choice==11)
				break;
			
			switch(choice)
			{
				case 1: 
					List.displayList();
					break;
				case 2:
					System.out.print("Enter the element to be inserted : ");
					data=scan.nextInt();
					List.insertInEmptyList(data);
					break;
				case 3:
					System.out.print("Enter the element to be inserted : ");
					data=scan.nextInt();
					List.insertInBeginning(data);
					break;
				case 4:
					System.out.print("Enter the element to be inserted : ");
					data=scan.nextInt();
					List.insertAtEnd(data);
					break;
				case 5:
					System.out.print("Enter the element to be inserted : ");
					data=scan.nextInt();
					System.out.print("Enter the element after which to insert : ");
					x = scan.nextInt();
					List.insertAfter(data, x);
					break;
				case 6:
					System.out.print("Enter the element to be inserted : ");
					data=scan.nextInt();
					System.out.print("Enter the element before which to insert : ");
					x = scan.nextInt();
					List.insertBefore(data, x);
					break;
				case 7:
					List.deleteFirstNode();
					break;
				case 8:
					List.deleteLastNode();
					break;
				case 9:
					System.out.print("Enter the element to be deleted : ");
					data = scan.nextInt();
					List.deleteNode(data);
					break;
				case 10:
					List.reverseList();
					break;
				default:
					System.out.println("Wrong choice");
					break;
			} /* ends switch */
			System.out.println();
		} /* ends while true */
		scan.close();
		System.out.println("Exiting");
	} /* ends main() */
} /* ends class */