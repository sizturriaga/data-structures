package string_problem;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String word = "arepera";
		
		long i = System.currentTimeMillis();
		System.out.println("is palindrome? "+isPalindrome(word));
		long f = System.currentTimeMillis();
		
		long time = f - i;
		System.out.println("time "+ time);
		

	}

	private static boolean isPalindrome(String sentence) {
		
		int lastOne = sentence.length() - 1;
		int sentenceLenght = (lastOne) / 2;
		
		for (int i = 0; i <= sentenceLenght; i++) {
			if(sentence.charAt(i) != sentence.charAt(lastOne - i)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isPalindrome2(String s) {
		
		String reverse = "";
		int length = s.length();
		
		for (int i = 0; i < length; i++) {
			reverse = reverse + s.charAt(length - i - 1);
		}
		
		if(s.equals(reverse))
			return true;
		
		return false;
	}
	
	private static boolean isPalindrome3(String sentence) {
		int i = 0;
		int j = sentence.length() - 1;
		int k = (i+j)/2;
		
		for (int index = i; index <= k; index++) {
			if(sentence.charAt(i) == sentence.charAt(j)) {
				i++;
				j--;
			}else {
				return false;
			}
		}
		return true;
	}
	
}
