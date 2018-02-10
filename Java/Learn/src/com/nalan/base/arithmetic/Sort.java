package com.nalan.base.arithmetic;

public class Sort {
    public static void main(String[] args) {
        Integer[] src = {-199, 20, 44, -206, 78, 0, 10, 44, 55};
        System.out.println(src);
//        bubble(src);
        sort(src);
        for(int i = 0; i < src.length; i++){
            System.out.println(src[i]);
        }
    }
    public static void bubble(int[] in){
        int temp;
        //外层循环从1开始，总是当前与后一个比较所以次数比正常少1
        for(int i = 1; i < in.length; i++){
            //内层循环从0开始，注意这里的循环条件"length-i"
            for(int j = 0; j < in.length - i; j++){
                if(in[j] > in[j + 1]){
                    temp = in[j];
                    in[j] = in[j + 1];
                    in[j + 1] = temp;
                }
            }
        }
        System.out.println(in);
    }
    public static <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        //当内层循环整个遍历一遍swapped仍未true，说明已经排序完成
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}
