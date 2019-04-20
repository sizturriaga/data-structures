package heap_imp;

public class Heap {

    private int[] heap;
    private int heapSize;

    Heap(){
        this.heap = new int[Constants.CAPACITY];
    }

    public void insert(int item){
        if(isHeapFull()) throw new RuntimeException("Heap is full");

        this.heap[heapSize++] = item;

        fixUpMax(heapSize - 1);
    }

    public int getMax(){
        return this.heap[0];
    }

    int poll(){

        int max = getMax();

        if(isEmpty()) throw new RuntimeException("Heap is empty");

        swap(0, heapSize - 1);
        this.heapSize--;

        fixDownMax(0);

        return max;
    }

    private boolean isEmpty() {
        return this.heapSize == 0;
    }

    void heapSort(){
        int size = this.heapSize;

        for (int i = 0; i < size; i++) {
            int max = poll();
            System.out.println(max+" ");
        }

    }

    private void fixDownMax(int currentIndex) {

        int indexLeft = 2 * currentIndex + 1;
        int indexRight = 2 * currentIndex + 2;
        int indexLargest = currentIndex;

        if(indexLeft < heapSize && this.heap[indexLeft] > this.heap[currentIndex])
            indexLargest = indexLeft;

        if(indexRight < heapSize && this.heap[indexRight] > this.heap[indexLargest])
            indexLargest = indexRight;

        if(currentIndex != indexLargest){
            swap(currentIndex, indexLargest);
            fixDownMax(indexLargest);
        }
    }

    private void fixUpMax(int currentIndex) {

        int parentIndex = (currentIndex - 1) / 2;
        if(currentIndex > 0 && this.heap[currentIndex] > this.heap[parentIndex]){
            swap(parentIndex, currentIndex);
            fixUpMax(parentIndex);
        }
    }

    private void swap(int index1, int index2) {
        int temp = this.heap[index1];
        this.heap[index1] = this.heap[index2];
        this.heap[index2] = temp;
    }


    private boolean isHeapFull() {
        return Constants.CAPACITY == heapSize;
    }
}
