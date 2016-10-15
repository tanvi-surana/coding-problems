package fundamentals;

import java.util.Scanner;

public class Power {
	public static void takeInput(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			Scanner console=new Scanner(System.in);
			arr[i]=console.nextInt();
		}
	}
	public static void print(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(" "+arr[i]);
		}
	}
	
	public static void merge(int a[],int b[],int arr[])
	{
		int k=0,i=0,j=0;
		while(i<a.length&&j<b.length)
		 {
			 
		 		if(a[i]>b[j])
				{
					arr[k]=b[j];
					j++;
					k++;
				}
		 		else
		 		{
		 			arr[k]=a[i];
		 			i++;
		 			k++;
		 		}
				 			 
        }
		if(i==a.length)
		{
			arr[k]=b[j];
		}
		else
		{
			arr[k]=a[i];
		}
}
	public static int power(int x,int n)
	{
		if(n==0)
		{
			return 1;
		}
		if (n==1)
		{
			return x;
		}
		return x*power( x,n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner console=new Scanner(System.in);
		/*System.out.println("Enter the number");
		int x=console.nextInt();
		System.out.println("Enter the power");
		int n=console.nextInt();
		int z=power(x,n);
		System.out.println("The result is "+z);*/
		
		System.out.println("Enter the size of array 1");
		int i=console.nextInt();
		System.out.println("Enter the size of array 2");
		int j=console.nextInt();
		System.out.println("Enter the array 1");
		int a[]=new int[i];
		takeInput(a);
		System.out.println("Enter array 2");
		int b[]=new int[j];
		takeInput(b);
		int c[]= new int[i+j];
		merge(a,b,c);
        print(c);
	}

}
