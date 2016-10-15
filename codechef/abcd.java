package codechef;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static long compute_max(long input[])
    {
    	long max=input[0];
    	for(int i=1;i<input.length;i++)
    	{
    		if(input[i]>max)
    		  max=input[i]; 
    	}
    	
    	return max;
    }
    
//    public static long[] calculate(long[] input)
//    {
//    	long max=compute_max(input);
//    	for(int i=0;i<input.length;i++)
//    	{
//    		input[i]=input[i]-max;
//    	}
//    	
//    	return input;
//    }
	public static void main (String[] args) throws java.lang.Exception
	{
		long n,k;
		Scanner console=new Scanner(System.in);
		n=console.nextLong();
		k=console.nextLong();
		long input[]=new long[(int) n];
		long arr[]=new long[(int)n];
		for(long i=0;i<input.length;i++)
		{
			input[(int) i]=console.nextLong();
		}
		for(long i=0;i<k;i++)
		{
		//	arr[i]=calculate(input);
			long max=compute_max(input);
	    	for(int i1=0;i1<input.length;i1++)
	    	{
	    		arr[i1]=input[i1]-max;
	    	} 		
	    	
	    	for(int j=0;j<n;j++)
	    	{
	    		input[j]=arr[j];
	    	}
		}
		
			for(long i=0;i<arr.length;i++)
		{
		     System.out.print(input[(int) i]+" ");
		}
		
	}
}