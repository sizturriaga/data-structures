package integer_problem;

public class IntegerReverse {

	public static void main(String[] args) {
		
		int reversed = integerReverser(4321);
		System.out.println(reversed);

	}

	private static int integerReverser(int number) {
		
		int reversed = 0;
		int lastNum = 0;
		while (number > 0) {
			lastNum = number % 10;
			number /= 10;
			reversed = reversed * 10 + lastNum;
		}
		return reversed;
	}

}
