package codechef;

import java.util.Scanner;

public class abab {

	public static boolean checkIfPrime(int num)
	{
		int count=0;
		for(int i=1;i<num;i++)
		{
			  if(num%i==0)
			  {
			  	count++;
			  	if(count>2)
			  	{
			  		return false;
			  	}
			  }
		}
	  return true;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int t;
				Scanner console=new Scanner(System.in);
				System.out.println("Enter the test cases");
				t=console.nextInt();
				for(int j=0;j<t;j++)
				{
					System.out.println("Enter the num "+j);
					int num=console.nextInt();
					for(int i=num;i<100001;i++)
					{
						int current=i;
						int sum=0,remain;
						while(current!=0)
						{
							remain=current%10;
							sum=sum*10+remain;
							current=current/10;
							
						}
						
						if(sum==i&&checkIfPrime(i))
							{
								System.out.println(i);
								break;
							}
					}
				}
				
	}

}
