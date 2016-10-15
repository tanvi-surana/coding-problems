package fundamentals;

import java.util.Scanner;

public class SelectionSort {
	 
	
	public static void takeInput(int input[])
	{
		for(int i=0;i<input.length;i++)
		{
			Scanner console=new Scanner(System.in);
			 input[i]=console.nextInt();
		}
	}
	public static void selectionSort(int input[])
	{
		for(int i=0;i<input.length;i++)
		{
			  int min=input[i];
			  for(int j=i+1;j<input.length;j++)
			  {
				  if(input[j]<min)
				  {
					 int temp=input[j];
					     input[j]=min;
					     min=temp;	   
				  }
			  }
			  input[i]=min;
		}
	}
	public static void printArray(int input[])
	{
		for(int i=0;i<input.length;i++)
		{
			System.out.println(input[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the number of inputs");
		int n=console.nextInt();
		int arr[]=new int[n];
        takeInput(arr);
        selectionSort(arr);
        printArray(arr);
	}

}
