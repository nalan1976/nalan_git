package easy.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static easy.string.SearchInsertPosition.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/* Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 1:

 Input: [1,3,5,6], 0
 Output: 0
* */

//@RunWith(Parameterized.class)
public class SearchInsertPositionTest {
//    public List<Integer> list/* = new ArrayList<>()*/;
//    public int[] arr;
//    public int tgt;

//    public SearchInsertPositionTest(List<Integer> list, int tgt) {
//        this.list = list;
//        this.tgt = tgt;
//    public  SearchInsertPositionTest(){}
//
//    public SearchInsertPositionTest(int[] arr, int tgt) {
//        this.arr = arr;
//        this.tgt = tgt;
//    }
    @Test
    public void test(){
//        List<SearchInsertPositionTest> input = new ArrayList<>();
        int[] arr = {1, 3, 5, 6};

        assertEquals(searchInsert(arr, 5), 2);
        assertEquals(searchInsert(arr, 2), 1);
        assertEquals(searchInsert(arr, 7), 4);
        assertEquals(searchInsert(arr, 0), 0);
        
        assertEquals(searchInsertBinary(arr, 5), 2);
        assertEquals(searchInsertBinary(arr, 2), 1);
        assertEquals(searchInsertBinary(arr, 7), 4);
        assertEquals(searchInsertBinary(arr, 0), 0);
    }
}



