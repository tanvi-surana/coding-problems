package fundamentals;

import java.util.Scanner;

public class Mississipi {

	public static String printLargestString(String input)
	{
		int startIndex=0;
		int endIndex=0;
		int newStart=0;
		int maxLen=0;
		String newString = "";
		int char1=input.charAt(0);
		for(int i=0;i<input.length();)
		{
			while(char1==input.charAt(i))
			{	
				i++;
			}
			char char2=input.charAt(i);
			newStart=i;
		
			while(input.charAt(i)==char2||input.charAt(i)==char1)
			{
				i++;
			}
			endIndex=i;
			int max=endIndex-startIndex+1;
			if(maxLen<max)
			{
				maxLen=max;
				newString=input.substring(startIndex, endIndex+1);
			}
			
			startIndex=newStart;
			char1=input.charAt(newStart);
		}
		
	   return newString;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	   Scanner console= new Scanner(System.in);
	   System.out.println("Enter the string");
	   String input=console.nextLine();
	   System.out.println(printLargestString(input));

	}

}
