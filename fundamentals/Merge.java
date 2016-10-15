package fundamentals;

import java.util.Scanner;

public class Merge {
	
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
	public static int[] merge(int a[],int b[])
	{
		int l=a.length+b.length;
		int arr[]=new int[l];
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
		while(i<a.length)
		{
			arr[k]=a[i];
			i++;
			k++;
		}
		while(j<b.length)
		{
			arr[k]=b[j];
			j++;
			k++;
		}
		
		return arr;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner console= new Scanner(System.in); 
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
			int c[]=merge(a,b);
	        print(c);
	}

}
