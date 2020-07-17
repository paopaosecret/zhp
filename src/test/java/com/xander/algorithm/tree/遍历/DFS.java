package com.xander.algorithm.tree.遍历;

import com.xander.algorithm.tree.TreeNode;

import java.util.Stack;

/**
 * DFS:深度优先搜索:先序（根左右），左根右（中序），左右根（后序）
 *
 * 非递归算法实现
 * 先序算法：利用栈的先进后出特性，先遍历根节点，然后先入栈右节点，再入栈子节点
 *
 * 1、根节点入栈成为top节点
 * 2、top节点出栈，获取其数据
 * 3、入栈top节点的右节点
 * 4、入栈top节点的子节点
 * 5、如果栈不为空，则循环2,3,4
 *
 * @作者 zhaobing04
 *
 * @创建日期 2020/7/17 15:35
 */
public class DFS {
    private static TreeNode treeNode1,treeNode2,treeNode3,treeNode4,treeNode5,treeNode6,treeNode7,treeNode8,treeNode9;
    private static Stack<TreeNode> stack = new Stack<>();
    public static void main(String args[]){
        initTree();
        depthFirstSearch(treeNode1);
    }

    public static void depthFirstSearch(TreeNode rootNode) {
        stack.add(rootNode);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.data + "  ");
            if(node.rightNode != null){         //右边先入栈，则后遍历
                stack.push(node.rightNode);
            }
            if(node.leftNode != null){
                stack.push(node.leftNode);
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
