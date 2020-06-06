package com.landray.kmss;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 帅
 * @Date 2020/5/24 15:17
 * @Description 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 **/
public class Demo07 {
    public static void main(String[] args) {
        System.out.println(getRow1(10));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0;i <= rowIndex;i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0;j <= i;j++){
                if(j == 0 || j == i){
                    list.add(1);
                }else{
                    list.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
                }
            }
            lists.add(list);
        }
        return lists.get(rowIndex);
    }

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }
}
