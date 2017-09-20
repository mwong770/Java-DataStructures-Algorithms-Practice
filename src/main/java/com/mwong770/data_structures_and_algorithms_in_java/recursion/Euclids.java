package com.mwong770.data_structures_and_algorithms_in_java.recursion;

import java.util.Scanner;

public class Euclids
{
//	this class is not for instantiation
	private Euclids() {}
	
//	finds greatest common divisor of two numbers
	public static int GCD(int a, int b)
	{
		if(b==0)
			return a;
		return GCD(b, a%b);
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int a,b;
		
		System.out.print("Enter values for a and b : ");
		a = scan.nextInt();
		b = scan.nextInt();
		
		System.out.println("GCD of " + a + " and " + b + " is " + GCD(a,b));
		
		scan.close();
	}
}