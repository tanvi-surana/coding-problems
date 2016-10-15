package fundamentals;

import java.util.Scanner;

public class FahrenheitToCelcius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		int fahrenheitValue=0;
		//int n;
		System.out.println("Please input the value");
		Scanner console =new Scanner(System.in);
		int maxFahrenheitValue = console.nextInt(); 
		while(fahrenheitValue<maxFahrenheitValue)
		{
		 int celcius=(fahrenheitValue-32)*5/9;
		 System.out.println(fahrenheitValue);
		 System.out.print(" ");
		 System.out.println(celcius);
		 System.out.println("\n");
		 fahrenheitValue+=1;
		}
		
	}

}
