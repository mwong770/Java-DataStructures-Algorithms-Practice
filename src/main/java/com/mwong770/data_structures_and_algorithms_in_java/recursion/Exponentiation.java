package com.mwong770.data_structures_and_algorithms_in_java.recursion;

import java.util.Scanner;

public class Exponentiation
{
//	this class is not for instantiation
	private Exponentiation() {}
	
//	finds nth power of x
	public static float power(float x, int n)
	{
		if(n==0)
			return 1;
		return x*power(x, n-1);
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		float x;
		int n;
		
		System.out.print("Enter values for x and n : ");
		x = scan.nextFloat();
		n = scan.nextInt();
		
		System.out.println(x + "^" + n + "=" + power(x,n));
		
		scan.close();
	}
}