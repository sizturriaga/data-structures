package array_problem;

import java.util.Arrays;

public class AnagramProblem {

	public static void main(String[] args) {
		String original = "aguardentosa";
		String anagrama = "engatusadora";
		
		System.out.println(original+" and "+anagrama+" are anagrams: "+isAnagram(original, anagrama));
	}

	private static boolean isAnagram(String original, String anagrama) {
		
		char[] charO = original.toCharArray();
		char[] charA = anagrama.toCharArray();
		
		Arrays.parallelSort(charO);
		Arrays.parallelSort(charA);
		
		for (int i = 0; i < charA.length; i++) {
			if(charO[i] != charA[i])
				return false;
		}
		
		return true;
	}

}
