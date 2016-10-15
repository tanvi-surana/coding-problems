package fundamentals;

import java.util.Scanner;

public class QuickSort {

	public static void takeInput(int input[])
	{
		Scanner console= new Scanner(System.in);
		for(int i=0;i<input.length;i++)
		{
			input[i]=console.nextInt();
		}
	}
	public static void printArray(int input[])
	{
		for(int i=0;i<input.length;i++)
		{
			System.out.println(input[i]);
		}
	}
	
	private static int partition(int[] input,int startIndex,int endIndex)
	{
		//find number of elements smaller than pivot
		int count=0;
	     int pivot=startIndex;
		for(int i=startIndex;i<endIndex;i++)
		{
			if(input[i]<input[pivot])
		    {
				count++;
			}
		}		
		//put pivot at the right place
	 count=pivot;
	
		int i=startIndex;
		int j=endIndex;
		while(i<j)
		{
			if(input[i]<input[count])
			{
				i++;
			}
			if(input[j]>input[count])
			{
				j--;
			}
			else
			{
				//swap the two
				int temp=input[i];
				input[i]=input[j];
				input[j]=temp;
			}
		}
		//partition
	return pivot; 
	
	}
	
	private static void quickSortHelper(int input[],int startIndex,int endIndex)
	{
		if(endIndex<=startIndex)
		{
			return;
		}
			int pivotIndex=partition(input,startIndex,endIndex);
			quickSortHelper(input,startIndex,pivotIndex-1);
			quickSortHelper(input,pivotIndex+1,endIndex);
			
	}
	
	public static void quickSort(int input[])
	{
		quickSortHelper(input,0,input.length-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner console=new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n=console.nextInt();
		System.out.println("Enter the array");
		int input[]=new int[n];
		takeInput(input);
		quickSort(input);
		System.out.println("The sorted array is");
		printArray(input);
	}

}
