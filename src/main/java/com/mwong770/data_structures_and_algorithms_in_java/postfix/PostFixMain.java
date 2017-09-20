package com.mwong770.data_structures_and_algorithms_in_java.postfix;

import java.util.Scanner;

public class PostFixMain
{
	public static void main(String[] args)
	{
		String infix;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter infix expression : ");
		infix = scan.nextLine();
		
		String postfix = infixToPostfix(infix);
		
		System.out.println("Postfix expression is : " + postfix);
		
		System.out.println("Value of expression : " + evaluatePostfix(postfix));
		
		scan.close();
	}
	
	public static String infixToPostfix(String infix)
	{
		String postfix = new String();
		
//		allocates a stack object that can store character values
		StackChar st = new StackChar(20);
		
		char next, symbol;
		
//		scans all the symbols in infix expression
		for(int i=0; i<infix.length(); i++)
		{
			symbol=infix.charAt(i);
			
			
//			ignores blanks and tabs
			if(symbol==' ' || symbol=='\t')
				continue;
			
			switch(symbol)
			{
				case '(':
	//				push it onto stack
					st.push(symbol);
					break;
				case ')':
	//				pop and add to postfix all operators till a ( is popped
					while((next=st.pop()) !='(')
						postfix = postfix + next;
					break;
					
	//			if operator
				case '+':
				case '-':
				case '*':
				case '/':
				case '%':
				case '^':
	//				pop and add to postfix all operators that have precedence >= precedence of the scanned operator
					while(!st.isEmpty() && precedence(st.peek())>=precedence(symbol))
						postfix=postfix+st.pop();
					st.push(symbol);
					break;
	//			if operand
				default:
	//				added to postfix
					postfix=postfix+symbol;
			}
		}
//		after all scanned, pop and add to postfix all operators remaining on stack
		while(!st.isEmpty())
			postfix=postfix + st.pop();
		return postfix;
	} /* ends infixToPostfix */
	
//	returns the precedence of an operator
	public static int precedence(char symbol)
	{
		switch(symbol)
		{
			case '(':
				return 0;
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
			case '%':
				return 2;
			case '^':
				return 3;
			default:
				return 0;
		}
	}
	
//	evaluates a postfix expression and returns its value
	public static int evaluatePostfix(String postfix)
	{
//		allocates stack object that stores integer values
		StackInt st = new StackInt(20);
		
		int x, y;
		
//		scans symbols of postfix expression
		for (int i=0; i<postfix.length(); i++)
		{
//			if the symbol is an operand it is pushed on the stack
			if(Character.isDigit(postfix.charAt(i)))
				st.push(Character.getNumericValue(postfix.charAt(i)));
//			if the symbol is an operator
			else
			{
//				pops two operands from stack 
				x=st.pop();
				y=st.pop();
				
//				applies operator to the popped operands and pushes the result on stack
				switch(postfix.charAt(i))
				{
					case '+':
						st.push(y+x); 
						break;
					case '-':
						st.push(y-x); 
						break;
					case '*':
						st.push(y*x); 
						break;
					case '/':
						st.push(y/x); 
						break;
					case '%':
						st.push(y%x); 
						break;
					case '^':
						st.push(y^x); 
						break;
				}
			}
		}
		
//		returns last value remaining in stack - the result of the postfix expression
		return st.pop();
	}
} /* ends class */
