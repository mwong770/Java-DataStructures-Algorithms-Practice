package com.mwong770.data_structures_and_algorithms_in_java.recursion;

import java.util.Scanner;

public class SumOfDigits
{
//	this class is not for instantiation
	private SumOfDigits() {}
	
//	finds sum of digits of a number recursively
	public static long sumDigits(long n)
	{
		if(n/10==0)
			return n;
		return sumDigits(n/10) + n%10;
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		long n;
		System.out.print("Enter a number : ");
		n=scan.nextLong();
		System.out.println(sumDigits(n));
		scan.close();
	}
}