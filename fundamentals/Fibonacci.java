package fundamentals;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the value");
		Scanner console =new Scanner(System.in);
		int num= console.nextInt();
		int first=0;
		int second=1,value=1,temp=first+second;
		System.out.println("0");
		System.out.println("1");
		if(num==1)
		{
			System.out.println("1");
		}
		else
		{
			while( temp<=num  )
			{
				//temp=first+second;
				first=second;
				second=temp;
     			//value++;
     			System.out.println(temp);
     			temp=first+second;
			}
		}
		

	}

}
