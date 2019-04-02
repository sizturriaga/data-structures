package array_problem;

public class SortArray {

	public static void main(String[] args) {
		Integer[] array = new Integer[] {4,1,9,3,5};
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.print("\n");
		orderArray(array);
	}
	
	private static void orderArray(Integer[] array) {

		int temp;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}

}
