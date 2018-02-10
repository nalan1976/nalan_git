package com.nalan.base.arithmetic;

public class BinarySearch {
    public static void main(String[] args) {
        int[] src = {-139, -94, -54, -44, -14, -4, 0, 45, 356, 786, 4444, 5555};
        System.out.println(myBinarySearch(src, 356));
/*        for(int i : src){
            System.out.println(src[i]);
        }*/
    }
    public static int myBinarySearch(int[] in, int key){
        int low = 0;
        int high = in.length - 1;
        //注意循环条件是<=
        while(in[low] <= in[high]){
            int mid= (low + high) >>> 1;//无符号右移

            if(in[mid] > key){
                high -= 1;
            }else if(in[mid] < key){
                low += 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
