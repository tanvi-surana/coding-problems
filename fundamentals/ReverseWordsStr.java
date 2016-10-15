package fundamentals;

import java.util.Scanner;

public class ReverseWordsStr {
	
	public static String reverse(String input)
	{
		String newString=""; 
		int endIndex=input.length();
		for(int i=input.length()-1;i>0;i--)
		{
			if(input.charAt(i)==' ')
			{
				newString = newString+ input.substring(i+1,endIndex)+" ";
	            endIndex=i;		
			}
			
		}
		
		newString= newString+input.substring(0,endIndex);
		return newString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console= new Scanner(System.in);
		String input=console.nextLine();
		String result=reverse(input);
		System.out.println(result);
	}

}
