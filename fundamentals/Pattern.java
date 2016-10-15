package fundamentals;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the value");
		Scanner console= new Scanner(System.in);
		int n = console.nextInt();
		int row,space,num,num1;
		//Pattern
		for(row=0;row<n;row++)
		{
			//space
			for(space=n-row-1;space>0;space--)
			{
				System.out.print(" ");
			}
			//first set of numbers
			int x=row+1;
			for(num=0;num<row+1;num++)
			{
				System.out.print(x++);
			}
			 
			
			int z=2*row;
			for(num1=1;num1<row+1;num1++)
			{
				System.out.print(z--);
			}
			System.out.print("\n");
			
		}
		

	}

}
