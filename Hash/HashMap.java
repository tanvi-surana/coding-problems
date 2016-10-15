package Hash;

import java.util.Set;

public class HashMap {

	public static String removeDuplicates(String input)
	{
		//String newString="";
		 java.util.HashMap<Character,Boolean> newString=new java.util.HashMap<Character, Boolean>();
		
		for(int i=0;i<input.length();i++)
		{	
			
			if(!newString.containsKey(input.charAt(i)))
			{
				newString.put(input.charAt(i),true);
			}
			
			
		}
	  	
         return newString.keySet().toString();
	}
	
	public static Integer[] findIntersection(int input1[],int input2[])
	{
		java.util.HashMap<Integer, Boolean> intersection=new java.util.HashMap<Integer, Boolean>();
		 
		for(int i=0;i<input1.length;i++)
		{
			intersection.put(input1[i], true);
		}		
		for(int i=0;i<input2.length;i++)
		{
			if(intersection.containsKey(input2[i]))
			{
				intersection.put(input2[i], true);
			}
		}		
		Set<Integer> arr=intersection.keySet();
		return arr.toArray(new Integer[0]);
	}
	public static Integer[] findUnion(int input1[],int input2[])
	{
		java.util.HashMap<Integer, Boolean> union=new java.util.HashMap<Integer, Boolean>();
		 
		for(int i=0;i<input1.length;i++)
		{
			union.put(input1[i], true);
		}		
		for(int i=0;i<input2.length;i++)
		{
			if(!union.containsKey(input2[i]))
			{
				union.put(input2[i], true);
			}
		}		
		Set<Integer> arr=union.keySet();
		return arr.toArray(new Integer[0]);
	}
	
	public static void pairWithSumZeros(int input[])
	{
		java.util.HashMap<Integer,Boolean> output=new java.util.HashMap<Integer, Boolean>();
		for(int i=0;i<input.length;i++)
		{
			output.put(input[i],true);
		}
		for(int i=0;i<input.length;i++)
		{
			if(output.containsKey(-1*input[i]))
			{
				System.out.println("Pair:"+ input[i]+" "+(-1*input[i]));
			}
				
		}
	}
	public static void tripletSumZero(int input[])
	{
		java.util.HashMap<Integer,Boolean> output=new java.util.HashMap<Integer, Boolean>();
		for(int i=0;i<input.length;i++)
		{
			output.put(input[i],true);
		}
		for(int i=0;i<input.length;i++)
		{
			if(output.containsKey(-1*(input[i]+input[i+1])))
			{
				System.out.println("triplets"+input[i]+" "+input[i+1]+" "+-1*(input[i]+input[i+1]));
		    }
		}
	}
	public static void main(String args[])
	{
//		String a="aabbccddeeefa";
//		System.out.print(removeDuplicates(a));
//		int input1[]={1,2,3,4,5};
//		int input2[]={4,1,2,3,6,7,8};
//		Integer[] result=findIntersection(input1, input2);
//		for(int i=0;i<result.length;i++)
//		{
//			System.out.print(result[i]+" ");
//		}
//		System.out.println();
//		Integer[] result1=findUnion(input1, input2);
//		for(int i=0;i<result1.length;i++)
//		{
//			System.out.print(result1[i]+" ");
//		}
		int[] input={-1,2,1,3,-2,4,5,6,-3};
//		pairWithSumZeros(input);
		tripletSumZero(input);
	}
	
}
