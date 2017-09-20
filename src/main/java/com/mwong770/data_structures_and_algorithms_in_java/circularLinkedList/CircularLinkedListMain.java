package com.mwong770.data_structures_and_algorithms_in_java.circularLinkedList;

import java.util.Scanner;

public class CircularLinkedListMain
{
	public static void main(String[] args)
	{
		int choice, data, x;
		Scanner scan = new Scanner(System.in);
		CircularLinkedList List = new CircularLinkedList();
		
		List.createList();
		
		while(true)
		{
			System.out.println("1. Display list");
			System.out.println("2. Insert in empty list");
			System.out.println("3. Insert in the beginning");
			System.out.println("4. Insert at the end");
			System.out.println("5. Insert after a node");
			System.out.println("6. Delete first node");
			System.out.println("7. Delete last node");
			System.out.println("8. Delete any node");
			System.out.println("9. Quit");
			
			System.out.print("Enter your choice : ");
			choice = scan.nextInt();
			
			if(choice==9)
				break;
			
			switch(choice)
			{
			case 1:
				List.displayList();
				break;
			case 2:
				System.out.print("Enter the element to be inserted : ");
				data = scan.nextInt();
				List.insertInEmptyList(data);
				break;
			case 3:
				System.out.print("Enter the element to be inserted : ");
				data = scan.nextInt();
				List.insertInBeginning(data);
				break;
			case 4:
				System.out.print("Enter the element to be inserted : ");
				data = scan.nextInt();
				List.insertAtEnd(data);
				break;
			case 5:
				System.out.print("Enter the element to be inserted : ");
				data = scan.nextInt();
				System.out.print("Enter the element after which to insert : ");
				x = scan.nextInt();
				List.insertAfter(data, x);
				break;
			case 6:
				List.deleteFirstNode();
				break;
			case 7:
				List.deleteLastNode();
				break;
			case 8:
				System.out.print("Enter the element to be deleted : ");
				data = scan.nextInt();
				List.deleteNode(data);
				break;
			default:
				System.out.println("Wrong choice");
			} /*ends switch */
			System.out.println();
		} /* ends while loop */
		scan.close();
		System.out.println("Exiting");
	} /* ends main() */
} /* ends class */