package fundamentals;

import java.util.Scanner;

public class MergeSort {
	 
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
	//Take input array and sort numbers between startIndex and endIndex
	//returns the sorted array in a  new array
	public static int[] mergeSort(int input[],int startIndex,int endIndex)
	{ 
		Scanner console=new Scanner(System.in);

        //Base Case
		if(startIndex==endIndex)
		{
			int output[]= new int[1];
			output[0]=input[startIndex];
			return output;
		}
	//Recursive calls to sort the two halves
	  
	  
   	   
       int mid=(startIndex+endIndex)/2;
	   int a[]=mergeSort(input,startIndex,mid); 
	   int b[]=mergeSort(input,mid+1,endIndex);
	   int c[]=merge(a,b);
        //Call our merge function to merge the two sorted halves
       return c;
		//return the output
       
       }
   	
	
	public static int[]  merge(int a[],int b[])
	{
		int k=0,i=0,j=0;
		int l=a.length+b.length;
		int arr[]=new int[l];
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
		 
	    System.out.println("Enter the size of the array");
		int n=console.nextInt();
		//int startIndex=0,endIndex=n-1;
		System.out.println("Enter the array");
	    int input[]=new int[n];
	    int input1[]=new int[n];
	    //takeInput(input);
	    for(int i=0;i<input.length;i++)
	    {
	    	input[i]=i++;
	    }
	    long startTime = System.nanoTime();
	    input1=mergeSort(input,0,input.length-1);
	    
	    long endTime = System.nanoTime();
	    long duration = (endTime - startTime);
	    System.out.println("The duration is "+duration/1000000);
	     
	   // print(input1); 
	    
	}

}
