package fenwick_tree_imp;

public class FenwickTree {

    int[] fenwickTree;

    FenwickTree(int[] nums) {
        this.fenwickTree = new int[nums.length + 1];
        construct(nums);
    }

    //sum up the numbers int the range of startIndex and endIndex
    //time complexity O(logN)
    public int rangeSum(int startIndex, int endIndex) {
        return sum(endIndex) - sum(startIndex - 1);
    }

    //sum up the numbers int the range of 0 to index
    //time complexity O(logN)
    public int sum(int index) {

        index++;
        int sum = 0;

        //we may consider the sum of multiples ranges so we have to iterate until index > 0
        while (index > 0){

            //binary index tree contains the sum of given ranges
            sum += this.fenwickTree[index];

            //go to the parent and keep going
            index = parent(index);

        }

        return sum;
    }

    //constructing the fenwick tree from the original array
    //time complexity O(NlogN)
    private void construct(int[] nums) {

        for (int index = 1; index <= nums.length; ++index) {
            update(index, nums[index - 1]);
        }

    }

    //update an existing item in the tree with index and value accordingly
    ////time complexity O(logN)
    private void update(int index, int num) {
        //have to check all the ranges includes in the index
        while (index < this.fenwickTree.length) {
            this.fenwickTree[index] += num;
            index = next(index);
        }
    }

    //index of the item on the left
    //time complexity O(1)
    private int next(int index) {
        return index + (index&-index);
    }

    //index of the item on the left
    //time complexity O(1)
    private int parent(int index) {
        return index - (index&-index);
    }

}
