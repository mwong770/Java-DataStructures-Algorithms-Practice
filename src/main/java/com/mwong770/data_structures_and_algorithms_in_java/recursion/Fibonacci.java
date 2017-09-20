package com.mwong770.data_structures_and_algorithms_in_java.recursion;

import java.util.Scanner;

public class Fibonacci
{
//	this class is not for instantiation
	private Fibonacci() {}
	
//	finds nth fibonacci number recursively
	public static int fib(int n)
	{
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fib(n-1) + fib(n-2);
	}
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter number of terms : ");
		int terms=scan.nextInt();
		
//		prints the fibonacci series
		for(int i=0; i<=terms; i++)
			System.out.print(fib(i) + " ");
		scan.close();
	}
}