package com.landray.kmss;

import java.util.PriorityQueue;

/**
 * @Author 帅
 * @Date 2020/5/23 22:36
 * @Description 使用优先队列获取无序数组中第k个最大值
 **/
public class Demo04 {
    public static void main(String[] args) {
        int[] arr = {9,4,6,3,8,2};
        System.out.println(solution(arr,3));
        int a = 4;
        int b = 6;
        System.out.println(a ^ b);
        System.out.println(321 ^ 0xFF);
        System.out.println(0xFF);
    }
    public static  int solution(int[] arr,int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(16,(i1,i2) ->{
            return i1-i2;
        });
        for (int num : arr){
                //先添加
                priorityQueue.offer(num);
                if(priorityQueue.size() > k){
                    priorityQueue.poll();
                }
        }
        return priorityQueue.poll();
    }
}
