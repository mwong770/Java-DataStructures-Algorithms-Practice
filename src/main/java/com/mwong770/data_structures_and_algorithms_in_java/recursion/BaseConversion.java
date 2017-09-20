package com.mwong770.data_structures_and_algorithms_in_java.recursion;

import java.util.Scanner;

public class BaseConversion
{
//	this class is not for instantiation
	private BaseConversion() {}
	
//	recursive method for finding a factorial of a number
	public static void toBinary(int n)
	{
		if(n==0)
			return;
		toBinary(n/2);
		System.out.print(n%2);
	}
	
//	prints n in binary, octal, or hexadecimal form depending on base
	public static void convertBase(int n, int base)
	{
		if(n==0)
			return;
		convertBase(n/base, base);
		
		int remainder=n%base;
		if(remainder<10)
			System.out.print(remainder);
		else
			System.out.print((char) (remainder-10+'A'));
	}
	
	public static void main(String[] args)
	{
		int n;
		Scanner scan=new Scanner(System.in);
		
		
		System.out.println("Enter a positive decimal number : ");
		n=scan.nextInt();
		
		System.out.print("Binary form : ");
		toBinary(n);
		System.out.println();
		
		System.out.print("Binary form : ");
		convertBase(n,2);
		System.out.println();
		
		System.out.print("Octal form : ");
		convertBase(n,8);
		System.out.println();
		
		System.out.print("Hexadecimal form : ");
		convertBase(n,16);
		System.out.println();
		
		scan.close();
	}
}