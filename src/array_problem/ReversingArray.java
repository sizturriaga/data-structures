package array_problem;

public class ReversingArray {

	public static void main(String[] args) {
		
		int[] array = new int[]{2,3,7,9,45,2,6,56};
		for (int i = 0; i < array.length; i++) 
			System.out.print(array[i] + " ");
		
		reverseArray(array);
		System.out.print("\n");
		
		for (int i = 0; i < array.length; i++) 
			System.out.print(array[i] + " ");

	}

	private static void reverseArray(int[] array) {
		
		int arrayLength = array.length - 1;
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[arrayLength - i];
			array[arrayLength - i] = temp;
		}
	}
	
	

}
