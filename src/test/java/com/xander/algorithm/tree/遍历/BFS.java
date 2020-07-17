package com.xander.algorithm.tree.遍历;

import com.xander.algorithm.tree.TreeNode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * BFS:广度优先搜索,一层一层的遍历
 *
 * 非递归算法实现
 * 遍历算法：利用队列的先进先出特性实现
 * 1、根节点入队成为队列头结点
 * 2、头结点出队，获取头节点数据
 * 3、头节点的子节点从左向右入队
 * 4、如果队列不是空，循环2,3操作
 *
 * @作者 zhaobing04
 *
 * @创建日期 2020/7/17 15:37
 */
public class BFS {
    private static TreeNode treeNode1,treeNode2,treeNode3,treeNode4,treeNode5,treeNode6,treeNode7,treeNode8,treeNode9;
    private static Queue<TreeNode> queue = new ConcurrentLinkedQueue();
    public static void main(String args[]){
        initTree();
        breadthFirstSearch(treeNode1);
    }

    public static void breadthFirstSearch(TreeNode treeNode1) {
        queue.add(treeNode1);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.data + "  ");
            if(node.leftNode != null){
                queue.add(node.leftNode);
            }
            if(node.rightNode != null){
                queue.add(node.rightNode);
            }
        }
    }

    private static void initTree() {
        treeNode1 = new TreeNode(1);
        treeNode2 = new TreeNode(2);
        treeNode3 = new TreeNode(3);
        treeNode4 = new TreeNode(4);
        treeNode5 = new TreeNode(5);
        treeNode6 = new TreeNode(6);
        treeNode7 = new TreeNode(7);
        treeNode8 = new TreeNode(8);
        treeNode9 = new TreeNode(9);

        treeNode1.leftNode = treeNode2;
        treeNode1.rightNode = treeNode3;
        treeNode2.leftNode = treeNode4;
        treeNode2.rightNode = treeNode5;
        treeNode3.leftNode = treeNode6;
        treeNode3.rightNode = treeNode7;
        treeNode5.leftNode = treeNode8;
        treeNode7.rightNode = treeNode9;
    }




}
