package StackLinkedList;

import java.util.Scanner;

public class ExpressionCheck {
	
	public static boolean checkExpression(String input)
	{
		Stack stack=new Stack();
		for(int i=0;i<input.length();i++)
		{
		  int currentChar=input.charAt(i);
		  if(currentChar>='a'&&currentChar<='b')
		  {
			  continue;
		  }
		  if(currentChar=='+'||currentChar=='-'||currentChar=='/'||currentChar=='*')
		  {
			  continue;
		  }
		  
		  if(currentChar=='{'||currentChar=='['||currentChar=='(')
		  {
			  stack.push(currentChar);
		  }
		  else if(currentChar=='}')
		  {
			  int top=stack.pop();
			  if(top!='{')
			  {
				  return false;
			  }
		  }
		  else if(currentChar==']')
		  {
			  int top=stack.pop();
			  if(top!='[')
			  {
				  return false;
			  }
		  }
		  else if(currentChar==')')
		  {
			  int top=stack.pop();
			  if(top!='(')
			  {
				  return false;
			  }
		  }
		  else if(!stack.isEmpty())
		  {
			  return false;
		  }
		}
	  return true;	
		  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input=new String();
		//Scanner console=new Scanner(System.in);
		//System.out.println("Enter the string");
		//input=console.nextLine();
		input="[{(a+b)}]";
		boolean x=checkExpression(input);
		System.out.println(x);

	}

}
