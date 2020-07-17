package com.xander.algorithm.tree.二叉树;

import com.xander.algorithm.tree.TreeNode;
import com.xander.algorithm.tree.遍历.BFS;
import com.xander.algorithm.tree.遍历.DFS;

import java.util.Random;
import java.util.Stack;

/**
 * 二叉树：二叉树（binary tree）是指树中节点的度不大于2的有序树，它是一种最简单且最重要的树。
 *
 * 1、插入 {@link #insertNode(TreeNode, int)}
 * 2、删除 {@link #deleteNode(TreeNode, int)}
 * 3、查找 {@link #searchNode(TreeNode, int)}
 *
 * @作者 zhaobing04
 *
 * @创建日期 2020/7/17 16:02
 */
public class BinaryTree {
    private static TreeNode root; //根节点
    private static Random random = new Random(System.currentTimeMillis());
    private static int index = 0;
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){     //TODO 使用i顺序插入
//            int data  = random.nextInt(10000);   //TODO 使用随机数随机插入
            insertNode(root, i);
        }
        System.out.println("\n广度遍历——————————————————————————————————");
        BFS.breadthFirstSearch(root);

        System.out.println("\n深度遍历——————————————————————————————————");
        DFS.depthFirstSearch(root);

        System.out.println("\n搜索节点——————————————————————————————————");
        TreeNode searchNode = searchNode(root, 5);
        if(searchNode == null){
            System.out.println("搜索到节点为空");
        }else{
            System.out.println("搜索到节点：" + searchNode.data);
        }

        System.out.println("\n搜索节点的父节点——————————————————————————————————");
        TreeNode parentNode = getParentNode(root, 5);
        if(parentNode == null){
            System.out.println("搜索到父节点为空");
        }else{
            System.out.println("搜索到父节点：" + searchNode.data);
        }

        System.out.println("\n删除节点0和 节点5——————————————————————————————————");
        deleteNode(root,5);
        deleteNode(root,0);
        DFS.depthFirstSearch(root);
//        deleteNode(data);
//        searchNode(data);
    }

    /**
     * 插入数据
     * 1、如果根节点为空，直接由数据生成根节点
     * 2、如果根节点不为空，数据小于根节点数据，如果根节点左子节点为空，将数据插入到左子节点，否则递归调用将数据插入到左子树
     * 3、如果根节点不为空，数据大于根节点数据，如果根节点右子节点为空，将数据插入到右子节点，否则递归调用将数据插入到右子树
     *
     * @param data
     */
    private static void insertNode(TreeNode rootNode, int data) {
        TreeNode node = new TreeNode(data);
        if(root == null){
            root = node;
        }else{
            if(data < rootNode.data){
                if(rootNode.leftNode == null){
                    rootNode.leftNode = node;
                }else{
                    insertNode(rootNode.leftNode, data);
                }
            }else{
                if(rootNode.rightNode == null){
                    rootNode.rightNode = node;
                }else{
                    insertNode(rootNode.rightNode, data);
                }
            }
        }
    }


    /**
     * 删除节点（分三种情况）
     * 1.删除叶子节点                   --》直接删除
     * 2.删除有一个子节点的节点         --》子节点替换该节点位置
     * 3.删除有两个子节点的节点         --》左子节点的右子节点为空，左子节点直接替换删除节点，否则：左子树最小节点数据替换此节点数据，删除左子树最小节点
     *
     * @param rootNode
     * @param data
     */
    private static void deleteNode(TreeNode rootNode, int data) {
        if(rootNode == null){
            System.out.println("树为空");
        }else{
            TreeNode parentNode = getParentNode(root, data); //要删除节点的父节点
            TreeNode currentNode = searchNode(root, data);  //要删除的当前节点
            if(currentNode == null){
                System.out.println("没有查找到该节点");
                return;
            }

            //TODO 第一种情况 删除的节点为叶子节点
            if(currentNode.leftNode == null && currentNode.rightNode == null){
                if(parentNode == null){  //TODO 删除的节点就是根节点，且没有子节点
                    root = null;
                }else {
                    if(parentNode.leftNode != null && parentNode.leftNode.data == currentNode.data){
                        parentNode.leftNode = null;

                    }
                    if(parentNode.rightNode != null && parentNode.rightNode.data == currentNode.data){
                        parentNode.rightNode = null;
                    }
                }
                return; //之后的逻辑不可能为叶子节点
            }

            //TODO 第二种情况 删除的节点有一个子节点
            if(currentNode.leftNode == null){
                if(parentNode == null){ //删除的为只有右节点的根节点
                    root = currentNode.rightNode;
                }else{
                    if(parentNode.leftNode != null && parentNode.leftNode.data == currentNode.data){
                        parentNode.leftNode = currentNode.rightNode;
                    }
                    if(parentNode.rightNode != null && parentNode.rightNode.data == currentNode.data){
                        parentNode.rightNode = currentNode.rightNode;
                    }
                }
                return;
            }

            if(currentNode.rightNode == null){
                if(parentNode == null){ //删除的为只有左节点的根节点
                    root = currentNode.leftNode;
                }else{
                    if(parentNode.leftNode != null && parentNode.leftNode.data == currentNode.data){
                        parentNode.leftNode = currentNode.leftNode;
                    }
                    if(parentNode.rightNode != null && parentNode.rightNode.data == currentNode.data){
                        parentNode.rightNode = currentNode.leftNode;
                    }
                }
                return;
            }

            //TODO 第三种情况删除节点的左右子节点都不为空
            TreeNode leftNode  = currentNode.leftNode;
            if(leftNode.rightNode == null){
                leftNode.rightNode = currentNode.rightNode;
                if(parentNode == null){ //删除根节点
                    root = leftNode;
                }
            }else{
                TreeNode rightMaxNode = findMaxNode(leftNode.rightNode); //获取数据右子树上的最大数据节点
                TreeNode rightMaxParentNode = getParentNode(root, rightMaxNode.data);

                currentNode.data = rightMaxNode.data;   //将最大节点数据复制给当前节点
                if(rightMaxNode.leftNode != null){      //删除右子树最大节点
                    rightMaxParentNode.rightNode = rightMaxNode.leftNode;
                }else{
                    rightMaxParentNode.rightNode = null;
                }
            }
        }
    }

    /**
     * 搜索树上的某个节点
     *
     * @param rootNode
     * @param data
     * @return
     */
    private static TreeNode searchNode(TreeNode rootNode, int data) {
        if(rootNode == null){
            return null;
        }else{
            if(data == rootNode.data){
                return rootNode;
            }else if(data < rootNode.data && rootNode.leftNode != null){
                return searchNode(rootNode.leftNode, data);
            }else if(data > rootNode.data && rootNode.rightNode != null){
                return searchNode(rootNode.rightNode, data);
            }
        }
        return null;
    }

    /**
     * 非递归实现，可查看{@link BFS}  和 {@link DFS}
     *
     * @param root
     * @param data
     * @return
     */
    public static TreeNode getParentNode(TreeNode root, int data){
        //TODO 使用DFS实现
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.rightNode != null){         //右边先入栈，则后遍历
                if(node.rightNode.data == data){
                    return node;
                }else{
                    stack.push(node.rightNode);
                }
            }
            if(node.leftNode != null){
                if(node.leftNode.data == data){
                    return node;
                }else{
                    stack.push(node.leftNode);
                }
            }
        }
        return null;
    }

    public static TreeNode findMaxNode(TreeNode node){
        if(node == null){
            return null;
        }
        if(node.rightNode == null){
            return node;
        }else{
            return findMaxNode(node.rightNode);
        }
    }
}
