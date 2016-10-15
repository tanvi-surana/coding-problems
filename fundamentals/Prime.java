package fundamentals;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		                                             //Print prime numbers upto n
		System.out.println("Please enter the value");
		Scanner console =new Scanner(System.in);
		int num= console.nextInt();
		int i,j;
		for(i=2;i<num;i++)
		{
			int p=0;
			for(j=2;j<i;j++)
			{
				if(i%j==0)
					p=1;
			}
			if(p==0)
			{
				System.out.println(i);
			}
		}
		

	}

}
