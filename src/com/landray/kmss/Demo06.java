package com.landray.kmss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 帅
 * @Date 2020/5/24 14:41
 * @Description 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 **/
public class Demo06 {
    public static void main(String[] args) {
        List<List<Integer>> lists = generate(12);
        for (int i = 0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
            for(int i = 0;i<numRows;i++){
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if(j == 0 || j == i){
                        list.add(1);
                    }else{
                        list.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
                    }
                }
                lists.add(list);
            }
        return lists;
    }
}
