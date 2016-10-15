package textProcessing;

public class PatternMatching {
	//Return -1 if found.otherwise return the index.
	public static int bruteForceMethod(String largeString,String toBeFound)
	{
			
		for(int i=0;i<largeString.length()-toBeFound.length()+1;i++)
			{
			   int k=0;
				for(int j=0;j<toBeFound.length();)
				{
					if(largeString.charAt(j+i)==toBeFound.charAt(j))
					{
						k++;
						if(k==toBeFound.length())
						{
							return i;
						}
					}
					j++;
				}
			}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int x=bruteForceMethod("abcdefacd","acd");
      System.out.println(x);
	}

}
