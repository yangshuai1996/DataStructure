package com.landray.kmss;

/**
 * @Author 帅
 * @Date 2020/5/24 18:16
 * @Description TODO
 **/
public class Demo08 {
    public static void main(String[] args) {
       // solution(10,8);
        int age = computeAge(8);
        System.out.println(age);
    }

    public static void doubleNum(int n)
    {
        System.out.println(n);
        if(n<=5000)
            doubleNum(n*2);
        System.out.println(n);
    }

    public static void solution(int age,int k){
        if(k == 1){
            System.out.println(age);
            return;
        }
        solution(age+2,k-1);
    }
    public static int computeAge(int n)
    {
        if(n==1)return 10;
        return computeAge(n-1) + 2;
    }
}
