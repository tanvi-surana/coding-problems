package codechef;

import java.util.HashMap;
import java.util.Scanner;

public class abc {
	
	
	public static void removeDuplicates(String input)
	 {
		int count=0;
	    HashMap<Character,Boolean> newString=new HashMap<Character, Boolean>();
		
		for(int i=0;i<input.length();i++)
		{	
			
			if(!newString.containsKey(input.charAt(i)))
			{
				newString.put(input.charAt(i),true);
               count++;   
			}
			
			
		}
	  	
       System.out.println(count);
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
	    
	   int t;
      Scanner console=new Scanner(System.in);
      System.out.println("Print t");
      t=console.nextInt();
      for(int i=0;i<t;i++)
      {
      	 String input;
      	 System.out.println("Enter the string"+i);
      	 input=console.next();
      	 removeDuplicates(input);
      }
  }
}
