package practise;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
//        int middle = sortedArray.length / 2;
/**     hand  crafted binary search
 *
        int begin = 0;
        int end = sortedArray.length-1;
        int mid = 0;

        while(begin <= end){    // <= is important
            mid = (begin + end)/2;
            if ( sortedArray[mid] < lessThan){
                begin = mid + 1;
            }else if(sortedArray[mid] > lessThan){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        //the below statement is very important as it's different from binary search
        //it's less rather than equal
        return  sortedArray[mid] < lessThan ? mid + 1 : mid;*/


        int num = Arrays.binarySearch(sortedArray, lessThan);
        return num >= 0 ? num : -num - 1;
    }

    public static void main(String[] args) {
        assertEquals(3, SortedSearch.countNumbers(new int[] { 1, 2, 3, 4, 5, 7 }, 4));
        assertEquals(2, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
        assertEquals(0, SortedSearch.countNumbers(new int[] {0} , 0));
        assertEquals(3, SortedSearch.countNumbers(new int[] {1,2,3} , 4));
        assertEquals(2, SortedSearch.countNumbers(new int[] {5,7,12} , 11));
        assertEquals(7, SortedSearch.countNumbers(new int[] {0,1,5,6,44,55,99,101} , 100));
        assertEquals(2, SortedSearch.countNumbers(new int[] {5, 6, 7, 9, 10} , 7));
        assertEquals(1, SortedSearch.countNumbers(new int[] {6,7,8} , 7));
    }
}
