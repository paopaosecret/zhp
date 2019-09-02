package com.xander.algorithm;

import java.util.Stack;

/**
 * Created by zhaobing04 on 2019/7/17.
 */
public class DFS {
    private static TreeNode treeNode1,treeNode2,treeNode3,treeNode4,treeNode5,treeNode6,treeNode7,treeNode8,treeNode9;
    private static Stack<TreeNode> stack = new Stack<>();
    public static void main(String args[]){
        initTree();
        depthFirstSearch(treeNode1);
    }

    private static void depthFirstSearch(TreeNode rootNode) {
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
