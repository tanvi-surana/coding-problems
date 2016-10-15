package fundamentals;

import java.util.Scanner;

public class CountChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter input");
		Scanner console = new Scanner(System.in);
		String inputString = console.next();
		char input = inputString.charAt(0);
		int count = 0;
		while(input != '$') 
		{
			count++;
			inputString = console.next();
			input = inputString.charAt(0);
		}
		
		System.out.println(count);

	}

}
