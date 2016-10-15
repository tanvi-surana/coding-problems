package text;

public class LCS {

	public static String lcsFast(String string1, String string2) {
		// dpStorage[i][j] is lcs of last i characters of string1 and last j characters of string 2
		String[][] dpStorage = new String[string1.length() + 1][string2.length() + 1];
		for (int i = 0; i <= string1.length(); i++) {
			dpStorage[i][0] = "";
		}
		for (int i = 0; i <= string2.length(); i++) {
			dpStorage[0][i] = "";
		}
		
		for (int j = 1; j <= string2.length(); j++) {
			for (int i = 1; i <= string1.length(); i++) {
				char char1 = string1.charAt(string1.length() - i);
				char char2 = string2.charAt(string2.length() - j);
				
				if (char1 == char2) {
					dpStorage[i][j] = char1 + dpStorage[i-1][j-1];
				} else {
					String option1 = dpStorage[i-1][j];
					String option2 = dpStorage[i][j-1];
					if (option1.length() > option2.length())
						dpStorage[i][j]  = option1;
					else 
						dpStorage[i][j]  = option2;
				}
				
			}
		}
		return dpStorage[string1.length()][string2.length()];
	}
	
	public static String lcsSlow(String string1, String string2) {
		if (string1 == null || string2 == null || string1.length() == 0 || string2.length() == 0) 
			return "";
		
		if (string1.charAt(0) == string2.charAt(0)) {
			return string1.charAt(0) + lcsSlow(string1.substring(1), string2.substring(1));
		} else {
			String option1 = lcsSlow(string1.substring(1), string2);
			String option2 = lcsSlow(string1, string2.substring(1));
			if (option1.length() > option2.length())
				return option1;
			return option2;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcsSlow("abcdef", "befabde"));
	}

}
