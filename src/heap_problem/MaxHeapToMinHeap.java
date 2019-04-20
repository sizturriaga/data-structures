package heap_problem;

public class MaxHeapToMinHeap {

    static int[] heap;
    static int heapSize;

    public static void main(String... args){
        heap = new int[]{210,100,23,2,5};
        heapSize = heap.length;

        checkValidMin(heap);

        for (int i : heap)
            System.out.println(i);
    }

    private static void checkValidMin(int[] heap) {
        for (int i = (heap.length - 2) / 2; i >= 0 ; i--)
            fixDownMax(i);
    }

    private static void fixDownMax(int currentIndex){

        int leftIndex = 2 * currentIndex + 1;
        int rightIndex = 2 * currentIndex + 2;
        int smallestIndex = currentIndex;

        if(leftIndex < heapSize && heap[leftIndex] < heap[currentIndex])
            smallestIndex = leftIndex;

        if(rightIndex < heapSize && heap[rightIndex] < heap[smallestIndex])
            smallestIndex = rightIndex;

        if(smallestIndex != currentIndex){
            System.out.println("swapping "+heap[currentIndex]+" <- "+heap[smallestIndex]);
            swap(currentIndex, smallestIndex);
            fixDownMax(smallestIndex);
        }
    }

    private static void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}
