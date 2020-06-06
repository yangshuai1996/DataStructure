package com.landray.kmss;

/**
 * @Author 帅
 * @Date 2020/5/24 13:48
 * @Description 判断一个数是否是回文数
 **/
public class Demo05 {
    public static void main(String[] args) {
        int num = 12345321;
        System.out.println(solution(num));
    }

    private static boolean solution(int num) {
        //获取数字的长度
        int length = String.valueOf(num).length();

        int k = 1;
        for (int i = 0; i < length; i++) {
            int a = (num / k) % 10;
            if(Integer.parseInt(String.valueOf(String.valueOf(num).charAt(i))) != a) return false;
            k = k * 10;
        }
        return true;
    }
}
