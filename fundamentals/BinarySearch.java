package fundamentals;

import java.util.Scanner;

public class BinarySearch {

	public static void takeInput(int input[])
	{
		for(int i=0;i<input.length;i++)
		{
			Scanner console=new Scanner(System.in);
			 input[i]=console.nextInt();
		}
	}
	
	public static void binarySearch(int input[],int num,int n)
	{
	     int low=0,high=n-1;
	     while(low<=high)
	     {
	    	 int mid=(low+high)/2;
	    	 if(num>input[mid])
	    	 {
	    		 low=mid+1;
	    	 }
	    	 if(num<input[mid])
	    	 {
	    		 high=mid-1;
	    	 }
	    	 if(num==input[mid])
	    	 {
	    		 System.out.println(mid+1);
	    		 break;
	    	 }
	    	
	     }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the number of inputs");
		int n=console.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the number to be searched");
		int num=console.nextInt();
        takeInput(arr);
        binarySearch(arr,num,n);
        
	}

}
