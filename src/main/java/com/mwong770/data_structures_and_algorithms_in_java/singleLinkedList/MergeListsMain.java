package com.mwong770.data_structures_and_algorithms_in_java.singleLinkedList;

public class MergeListsMain
{
	public static void main(String[] args)
	{
		SingleLinkedList list1 = new SingleLinkedList();
		SingleLinkedList list2 = new SingleLinkedList();
		
//		creates lists
		list1.createList();
		list2.createList();
		
//		sorts lists
		list1.BubbleSortData();
		list2.BubbleSortData();
		
		System.out.println("First List - "); list1.displayList();
		System.out.println("Second List - "); list2.displayList();
		
		SingleLinkedList list3;
		
//		merges lists with merge1
		list3 = list1.merge1(list2);
		System.out.println("Merged List - "); list3.displayList();
		
		System.out.println("First List - "); list1.displayList();
		System.out.println("Second List - "); list2.displayList();
		
//		merges lists with merge2
		list3 = list1.merge2(list2);
		System.out.println("Merged List - "); list3.displayList();
		
		System.out.println("First List - "); list1.displayList();
		System.out.println("Second List - "); list2.displayList();
	}
}