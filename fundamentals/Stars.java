package fundamentals;

import java.util.Scanner;


public class Stars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number");
		Scanner console=new Scanner(System.in);
		int num=console.nextInt();
		int temp=num;
		for(int i=0;i<num;i++)
		{
			for(int j=num-i-1;j>0;j--)
			{
				System.out.print("*");
			}
	
		   /* for(int k=1;k<temp+i;k++)
		    {
		    	System.out.print("#");
		    	temp--;
		    }
			 */
			System.out.print("\n");
		}
		

	}

}
