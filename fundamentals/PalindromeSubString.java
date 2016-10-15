package fundamentals;
//date-21/09/2014
public class PalindromeSubString {

	public static boolean checkIfPalindrome(String input)
	{
		int start=0;
		int end=input.length()-1;
		while(start<end)
		{
			if(input.charAt(start)==input.charAt(end))
			{
				start++;
				end--;
			}
			else 
			return false;
		}
	return true;	
	}
	
	public static int generateSubString(String input)
	{
		int count=0;
		for(int i=0;i<input.length();i++)
		{
			for(int j=i+1;j<input.length()+1;j++)
			{
			  if( checkIfPalindrome(input.substring(i, j)))
			  {
				  count++;
			  }
				
				
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//boolean x=checkIfPalindrome("aaba");
	//System.out.println(x);
	int x=generateSubString("abaa");
	System.out.println(x);
	}

}
