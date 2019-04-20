package heap_problem;

/**
 * Algorithms to validate if the given array is a correct min heap tree
 */
public class CheckMinHeap {

    static int[] heap;
    static int heapSize;

    public static void main(String... args) {
        //heap = new int[]{2, 5, 23, 210, 100};
        heap = new int[]{10,14,19,26,31,42,27,44,51,50,100,200,300,400,600,0};
        heapSize = heap.length;
        System.out.println(checkValidMin(0));
        System.out.println();
        System.out.println(checkValidMin(heap));
    }

    //it doesn't work
    private static boolean checkValidMin(int currentIndex) {

        int indexLeft = 2 * currentIndex + 1;
        int indexRight = 2 * currentIndex + 2;

        if (indexLeft < heapSize && indexRight < heapSize) {
            if (heap[indexLeft] < heap[currentIndex] && heap[indexRight] < heap[currentIndex])
                return false;
        } else
            return true;

        return (checkValidMin(indexLeft) && checkValidMin(indexRight));
    }

    private static boolean checkValidMin(int[] heap) {

        //((heap.length - 2) / 2) - Formula to get just the number of nodes with child
        for (int i = 0; i <= (heap.length - 2) / 2; i++)
            if (heap[i] > heap[2 * i + 1] || heap[i] > heap[2 * i + 2])
                return false;

        return true;
    }
}
