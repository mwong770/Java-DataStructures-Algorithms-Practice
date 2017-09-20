package com.mwong770.data_structures_and_algorithms_in_java.recursion;

import java.util.Scanner;

public class Display1ToN
{
	public static void printNTo1(int n)
	{
		if(n==0)
			return;
		System.out.print(n + " ");
		printNTo1(n-1);
	}
	
	public static void print1ToN(int n)
	{ 
		if(n==0)
			return;
		print1ToN(n-1);
		System.out.print(n + " ");
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n;
		System.out.println("Enter value of n : ");
		n=scan.nextInt();
		
		printNTo1(n);
		System.out.println();
		
		print1ToN(n);
		System.out.println();
		
		scan.close();
	}
	
	
}