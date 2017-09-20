package com.mwong770.data_structures_and_algorithms_in_java.headerList;

import java.util.Scanner;

public class HeaderListMain
{
	public static void main(String[] args)
	{
		int choice, data, x, k;
		Scanner scan = new Scanner(System.in);
		
		HeaderList List = new HeaderList();
		
		while(true)
		{
			System.out.println("1. Display List");
			System.out.println("2. Insert a node at the end of the list");
			System.out.println("3. Insert a node before a node");
			System.out.println("4. Insert at a given position");
			System.out.println("5. Delete a node");
			System.out.println("6. Reverse the list");
			System.out.println("7. Quit");
			System.out.println("Enter your choice : ");
			choice = scan.nextInt();
			
			if(choice==7)
				break;
			
			switch(choice)
			{
				case 1: 
					List.displayList();
					break;
				case 2: 
					System.out.print("Enter the element to be inserted : ");
					data = scan.nextInt();
					List.insertAtEnd(data);
					break;
				case 3: 
					System.out.print("Enter the element to be inserted : ");
					data = scan.nextInt();
					System.out.print("Enter the element before which to insert : ");
					x = scan.nextInt();
					List.insertBefore(data,x);
					break;
				case 4: 
					System.out.print("Enter the element to be inserted : ");
					data = scan.nextInt();
					System.out.print("Enter the position at which to insert : ");
					k = scan.nextInt();
					List.insertAtPosition(data,k);
					break;
				case 5:
					System.out.print("Enter the element to be deleted : ");
					data = scan.nextInt();
					List.deleteNode(data);
					break;
				case 6: 
//					List.reverse();
					break;
				default:
					System.out.println("Wrong choice");
			} /* ends switch */
		} /* ends while loop */
	} /* ends main() */
} /* ends class */