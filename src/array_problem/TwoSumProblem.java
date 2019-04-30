package array_problem;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static void main(String... args){

        int[] array = {3,5,2,-4,8,11};//{-4,2,3,5,8,11}
        int num = 7;

        findTwoSumNumbersMap(array, num);
        System.out.println();
        findTwoSumNumbersArray(array, num);
    }

    //using array O(N*2)
    private static void findTwoSumNumbersArray(int[] array, int num){

        for (int i = 0; i < array.length; i++) {
            for (int j = (i + 1); j < array.length; j++)
                if(array[i] + array[j] == num)
                    System.out.println("["+array[i] +","+array[j]+"] = "+num);
        }
    }

    //using dynamic programing O(N) | extra memory but less time complexity
    private static void findTwoSumNumbersMap(int[] array, int num){
        Map<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            int remainder = num - array[i];
            //O(1)
            if(map.containsValue(remainder))
                System.out.println("["+remainder+","+array[i]+"] = "+num);

            map.put(i,array[i]);
        }
    }


}
