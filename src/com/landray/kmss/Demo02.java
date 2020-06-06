package com.landray.kmss;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 二叉树的层序遍历
 * @Author 帅
 * @Date 2020/5/3 14:24
 **/
public class Demo02 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        int depth = depth(root);
        List<Integer> list = null;
        for (int i  = 1 ;i<=depth;i++){
            list = new ArrayList<>();
            levelOrder(root,i,list);
            lists.add(list);
        }
        return lists;
    }
    /**
     * @Description 获取二叉树的高度
     * @Date 2020/5/3 14:26
     * @Param [root]
     **/
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = depth(root.getLeft());
        int r = depth(root.getRight());
        if(l > r){
            return l + 1;
        }else {
            return r + 1;
        }
    }
    /**
     * @Description 根据level层级获取该层的数据
     * @Date 2020/5/3 14:30
     * @Param [root, level]
     **/
    public void levelOrder(TreeNode root, int level,List<Integer> list){
        if(level == 1 || root == null){
            if(root != null){
                list.add(root.getVal());
            }
            return;
        }
        levelOrder(root.getLeft(),level -1,list);
        levelOrder(root.getRight(),level -1, list);
    }
}
