package com.mwong770.data_structures_and_algorithms_in_java.parenthesesCheck;

import java.util.Scanner;

public class ParenthesesCheckMain
{
	public static void main(String[] args)
	{
		String expression;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter an expression wiht parenthesis : ");
		expression = scan.nextLine();
		
		if(isValid(expression))
			System.out.println("Valid expression");
		else
			System.out.println("Invalid expression");
		scan.close();
	}
	
	public static boolean isValid(String expr)
	{
		StackA st = new StackA();
		
		char ch;
		
//		scans all the symbols of the expression
		for(int i=0; i<expr.length(); i++)
		{
//			if left parenthesis push it on stack
			if(expr.charAt(i)=='(' || expr.charAt(i)=='{' || expr.charAt(i)=='[')
				st.push(expr.charAt(i));
			
//			if right parenthesis
			if(expr.charAt(i)==')' || expr.charAt(i)=='}' || expr.charAt(i)==']')
				
//				if stack is empty
				if(st.isEmpty())
				{
//					false because right parenethesis more than left parenthses
					System.out.println("Right parenthesis are more than left parenthesis");
					return false;
				}
				else
				{
//					pop a left parenthesis from the stack
					ch= st.pop();
					
//					if popped left parenthesis doesn't match scanned right parenthesis
					if(!matchParentheses(ch,expr.charAt(i)))
					{
//						returns false
						System.out.println("Mismatched parenthesis are : ");
						System.out.println(ch + " and " + expr.charAt(i));
						return false;
					}
				}
		}
		
//		if stack empty after all parenthesis scanned
		if(st.isEmpty())
		{
//			returns true
			System.out.println("Balanced Parentheses");
			return true;
		}
		else
		{
//			returns false because left parentheses  more than right parentheses
			System.out.println("Left parentheses are more than right parenthesis");
			return false;
		}
	} /* ends isValid() */
	
//	compares left and right parentheses
	public static boolean matchParentheses(char leftPar, char rightPar)
	{
		if(leftPar=='[' && rightPar==']')
			return true;
		if(leftPar=='{' && rightPar=='}') 
			return true;
		if(leftPar=='(' && rightPar==')')
			return true;
		return false;
	}
}
