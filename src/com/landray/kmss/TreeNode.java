package com.landray.kmss;

/**
 * @Description 树节点
 * @Author 帅
 * @Date 2020/5/2 13:50
 **/
public class TreeNode {
    private int val; //值
    private TreeNode left;//左节点
    private TreeNode right;//右节点

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
