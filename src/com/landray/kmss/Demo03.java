package com.landray.kmss;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author 帅
 * @Date 2020/5/23 19:34
 * @Description 二叉树的前序、中序、后序、层级遍历方法
 **/
public class Demo03 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        //preOrderTraversal1(root);
        //preOrderTraversal2(root);
        //midOrderTraversal1(root);
        //midOrderTraversal2(root);
        //postOrderTraversal1(root);
        //postOrderTraversal2(root);
        hierarchicalTraversal(root);
    }
    /**
     * @Description TODO
     * @Param 使用栈的方式进行前序遍历(非递归)
     **/
  static  void preOrderTraversal1(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if(treeNode.getRight() != null){
                stack.push(treeNode.getRight());
            }
            if(treeNode.getLeft()!= null){
                stack.push(treeNode.getLeft());
            }
            System.out.println(treeNode.getVal());
        }
    }
    /**
     * @Description TODO
     * @Param 使用递归的方式进行前序遍历
     **/
    static  void preOrderTraversal2(TreeNode root){
        if(root == null) return;
        System.out.println(root.getVal());
        preOrderTraversal2(root.getLeft());
        preOrderTraversal2(root.getRight());
    }
    /**
     * @Description TODO
     * @Param 使用递归的方式进行中序遍历
     **/
    static void midOrderTraversal1(TreeNode root){
        if(root == null) return;
        midOrderTraversal1(root.getLeft());
        System.out.println(root.getVal());
        midOrderTraversal1(root.getRight());
    }
    /**
     * @Description TODO
     * @Param 使用非递归的方式进行中序遍历
     **/
    static void midOrderTraversal2(TreeNode head){
        if(head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(head != null || !stack.isEmpty()){
            if(head != null){
                stack.push(head);
                head = head.getLeft();
            }else{
                head = stack.pop();
                System.out.println(head.getVal());
                head = head.getRight();
            }
        }
    }
    /**
     * @Description TODO
     * @Param 使用递归的方式进行后序遍历
     **/
    static  void postOrderTraversal1(TreeNode head){
        if(head == null) return;
        postOrderTraversal1(head.getLeft());
        postOrderTraversal1(head.getRight());
        System.out.println(head.getVal());
    }
    /**
     * @Description TODO
     * @Param 使用非递归的方式进行后序遍历(需要使用两个栈)
     **/
    static void postOrderTraversal2(TreeNode head){
            if(head == null) return;
            Stack<TreeNode> s1 = new Stack<>();
            s1.push(head);
            Stack<TreeNode> s2 = new Stack<>();
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.getLeft() != null){
                    s1.push(head.getLeft());
                }
                if(head.getRight() != null){
                    s1.push(head.getRight());
                }
            }
            while(!s2.isEmpty()){
                System.out.println(s2.pop().getVal());
            }
    }
    /**
     * @Description TODO
     * @Param 层次遍历
     **/
    static void hierarchicalTraversal(TreeNode treeNode){
        if(treeNode == null) return;
        //使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            treeNode = queue.poll();
            System.out.println(treeNode.getVal());
            if(treeNode.getLeft() != null){
                queue.offer(treeNode.getLeft());
            }
            if(treeNode.getRight() != null){
                queue.offer(treeNode.getRight());
            }
        }
    }
}