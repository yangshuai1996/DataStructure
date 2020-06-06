package com.landray.kmss;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author 帅
 * @Date 2020/5/30 22:45
 * @Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 **/
public class Demo09 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    /**
     * @Description TODO
     * @Param 任何数于0异或为任何数 0 ^ n => n
     *          相同的数异或为0: n ^ n => 0
     **/
    public static int singleNumber(int[] nums){
        int length = nums.length;
        int  result= 0;
        for (int i = 0;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
    public static int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);
        }
        Set<Integer> keySet = map.keySet();
        for(Integer num : keySet){
            if(map.get(num) == 1){
                return  num;
            }
        }
        return 0;
    }
}
