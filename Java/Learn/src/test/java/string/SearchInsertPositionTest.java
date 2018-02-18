package com.nalan.learn.arithmetic.easy.string;
import com.nalan.learn.arithmetic.easy.string.*;
import org.junit.Test;
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


public class SearchInsertPositionTest {
//    public List<Integer> list/* = new ArrayList<>()*/;
    public int[] arr;
    public int tgt;

//    public SearchInsertPositionTest(List<Integer> list, int tgt) {
//        this.list = list;
//        this.tgt = tgt;

    public SearchInsertPositionTest(int[] arr, int tgt) {
        this.arr = arr;
        this.tgt = tgt;
    }
    @Test
    public void test(){
        List<SearchInsertPositionTest> input = new ArrayList<>();
        int[] arr = {1, 3, 5, 6};
//        SearchInsertPositionTest sch = new  SearchInsertPositionTest( arr, 5);
        input.add( new  SearchInsertPositionTest( arr, 5));
        input.add( new  SearchInsertPositionTest( arr, 2));
        input.add( new  SearchInsertPositionTest( arr, 7));
        input.add( new  SearchInsertPositionTest( arr, 0));
//        arr = {}
//        for (int i = 0; i < input.size(); i++){
//
//        }
        assertEquals(SearchInsertPosition.searchInsert(input.get(0).arr, input.get(0).tgt));

    }
}



