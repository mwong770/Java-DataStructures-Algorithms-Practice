package com.mwong770.data_structures_and_algorithms_in_java.recursion;

import java.util.Scanner;

public class Factorial
{
//	this class is not for instantiation
	private Factorial() {}
	
//	recursive method for finding a factorial of a number
	public static long factorial(int n)
	{
		if(n==0)
			return 1;
		return n*factorial(n-1);
	}
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		
		int n;
		System.out.println("Enter a number greater than or equal to zero : ");
		n=scan.nextInt();
		
		System.out.println("Factorial of " + n + " is " + factorial(n));
		scan.close();
	}
}