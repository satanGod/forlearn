package com.learn.demo.algorithm;

/**
 * <h5>冒泡排序</h5>
 * <pre>
 *  冒泡排序规则：
 *     1、比较两个相邻的对象；
 *     2、如果左边的大于右边的，则调换位置；
 *     3、向右移动一个位置，比较接下来的两个对象；
 * </pre>
 *
 */
public class BubbleSort {
    private int[] arr;
    private int nElems;
    public BubbleSort(int max){
        arr = new int[max];
        nElems = 0;
    }
    public void insert(int value){
        arr[nElems++] = value;
    }
    public void display(){
        for(int j = 0 ; j < nElems ; j++){
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序，大O表示法时间复杂度为N²，计算次数为n*n/2次。
     */
    public void bubbleSort(){
        for(int out = nElems - 1 ; out > 1 ;out--){
            for(int in = 0 ; in < out ; in++){
                if(arr[in] > arr[in + 1])swap(in,in + 1);
            }
        }

    }

    private void swap(int one , int two){
        int temp = arr[two];
        arr[two] = arr[one];
        arr[one] = temp;
    }

    public static void main(String[] args) {
        int maxSize = 20;
        BubbleSort arr = new BubbleSort(maxSize);
        arr.insert(99);
        arr.insert(86);
        arr.insert(22);
        arr.insert(36);
        arr.insert(15);
        arr.insert(47);
        arr.insert(90);
        arr.insert(1);
        arr.insert(6);
        arr.insert(11);
        arr.insert(66);
        arr.display();
        long startTime = System.nanoTime();
        arr.bubbleSort();
        long endTime  = System.nanoTime();
        arr.display();
        System.out.println("排序耗时："+(endTime - startTime)+"纳秒");
    }

}

