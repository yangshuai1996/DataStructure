package com.landray.kmss;

import java.util.*;

/**
 * @Description 给定一个二叉树，检查它是否是镜像对称的。(对称二叉树)
 * @Author 帅
 * @Date 2020/5/2 13:48
 **/
public class Demo01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        //levelOrder(root, 1);
        boolean flag = printFromTopToBottom(root);
        System.out.println(flag);
        //depth(root);
        //boolean flag = isSymmetric(root);
        //System.out.println(flag);
    }
    /**
     * @Description 层级打印二叉树
     * @Date 2020/5/2 13:56
     * @Param [root]
     **/
    public static void println(TreeNode root, LinkedList<TreeNode> queue) {
        System.out.println(root.getVal());
        if (root.getLeft() != null || root.getRight() != null) {
            queue.add(root.getLeft());
            queue.add(root.getRight());
        }
        if (queue.size() != 0) {
            TreeNode treeNode = queue.pop();
            println(treeNode, queue);
        }
    }

    /**
     * @Description 非递归方式打印
     * @Date 2020/5/2 22:55
     * @Param [root]
     **/
    public static void println(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            //从队列中弹出一个节点
            TreeNode treeNode = queue.poll();
            if (treeNode.getLeft() != null) {
                queue.offer(treeNode.getLeft());
            }
            if (treeNode.getRight() != null) {
                queue.offer(treeNode.getRight());
            }
            System.out.print(treeNode.getVal() + " ");
        }
    }

    public static void levelOrder(TreeNode root, int level,List<Integer> list) {
      /*  if (root == null || level < 1) {
            return;
        }*/
        if (level == 1 || root == null) {
            list.add(root == null ? null : root.getVal());
            return;
        }
        //左子树
        levelOrder(root.getLeft(), level - 1,list);
        //右子树
        levelOrder(root.getRight(), level - 1,list);
    }

    public static boolean printFromTopToBottom(TreeNode pTreeRoot) {
        /*if (pTreeRoot == null) {
            return;
        }*/
        int depth = depth(pTreeRoot);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = null;
       /* for (int i = 1; i <= depth; ++i) {
            list = new ArrayList<>();
            levelOrder(pTreeRoot, i,list);
            lists.add(list);
        }*/
       for(int i =depth;i>0;i--){
           list = new ArrayList<>();
           levelOrder(pTreeRoot, i,list);
           lists.add(list);
       }
        //判断每一层中数据是否对应
        boolean flag = true;
        for(int i = 1;i<lists.size();i++){
            List<Integer> temp = lists.get(i);
            for (int j = 0; j < temp.size()/2; j++) {
                if(temp.get(j) != temp.get(temp.size() - j -1)){
                    flag = false;
                }
            }
        }
        return  flag;
    }
    /**
     * @Description 获取二叉树的深度
     * @Date 2020/5/3 13:28
     * @Param [pTreeRoot]
     **/
    private static int depth(TreeNode pTreeRoot) {
        if (pTreeRoot == null) {
            return 0;
        }
        int l = depth(pTreeRoot.getLeft());
        int r = depth(pTreeRoot.getRight());
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmertric(root.getLeft(), root.getRight());
    }
    /**
     * @Description //TODO
     * @Date 2020/5/3 14:09 
     * @Param [t1, t2]
     **/
    private static boolean isSymmertric(TreeNode t1,TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.getVal() != t2.getVal()) return false;
        return isSymmertric(t1.getLeft(), t2.getRight()) && isSymmertric(t1.getRight(), t2.getLeft());
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每次都取出一层的所有数据
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.getVal());
                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());
            }
            // 每次都往队头塞
            result.addFirst(oneLevel);
        }
        return result;
    }
}