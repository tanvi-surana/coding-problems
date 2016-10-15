package text;

public class EditDistance {

	public static int EDSlow(String s1, String s2) {
		if (s1.length() == 0)
			return s2.length();
		if (s2.length() == 0)
			return s1.length();
		
		if (s1.charAt(0) == s2.charAt(0)) 
			return EDSlow(s1.substring(1), s2.substring(1));
		else {
			int option1 = EDSlow(s1.substring(1), s2.substring(1));
			int option2 = EDSlow(s1, s2.substring(1));
			int option3 = EDSlow(s1.substring(1), s2);
			return 1 + Math.min(option1, Math.min(option2, option3));
		}
	}
	
	public static void main(String args[]) {
		System.out.println(EDSlow("ab", "bab"));
	}
}
