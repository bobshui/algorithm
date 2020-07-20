package codeInterview.questions;

import java.util.Stack;

/**
 *  树的概念包含：路径，根节点，父节点，子节点，兄弟节点，叶节点，子树，层，深度，高度
 *  层次：从根开始定义，根为第一层，根的子节点为第二层，以此类推。
 *  深度：对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0；
 *  高度：对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0；
 */

public class P02_BinaryTreeNode {
    public int data;
    public P02_BinaryTreeNode leftChild;
    public P02_BinaryTreeNode rightChild;

    public P02_BinaryTreeNode(int data) {
        this.data = data;
    }

    /** 比较常用的有前序遍历，中序遍历和后序遍历。
     *  中序遍历:左子树——》根节点——》右子树
     *  前序遍历:根节点——》左子树——》右子树
     *  后序遍历:左子树——》右子树——》根节点
     *  递归的遍历方法比较容易理解，代码也更为简洁
     */

    //递归中序遍历
    public void infixOrder(P02_BinaryTreeNode treeNode){
        if(treeNode != null){
            infixOrder(treeNode.leftChild);
            System.out.print(treeNode.data+" ");
            infixOrder(treeNode.rightChild);
        }
    }

    //递归前序遍历
    public void preOrder(P02_BinaryTreeNode treeNode){
        if(treeNode != null){
            System.out.print(treeNode.data+" ");
            preOrder(treeNode.leftChild);
            preOrder(treeNode.rightChild);
        }
    }

    //递归后序遍历
    public void postOrder(P02_BinaryTreeNode treeNode){
        if(treeNode != null){
            postOrder(treeNode.leftChild);
            postOrder(treeNode.rightChild);
            System.out.print(treeNode.data+" ");
        }
    }

    //非递归大多借用栈来实现
    //非递归前序遍历
    public void preOrder2(P02_BinaryTreeNode treeNode) {
        Stack<P02_BinaryTreeNode> stack = new Stack<P02_BinaryTreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.data+" ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    //非递归中序遍历
    public void inOrder2(P02_BinaryTreeNode treeNode) {
        Stack<P02_BinaryTreeNode> stack = new Stack<P02_BinaryTreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.data+" ");
                treeNode = treeNode.rightChild;
            }
        }
    }

    // 用非递归的方法进行后序遍历
    public void postOrder2(P02_BinaryTreeNode treeNode) {
        Stack<P02_BinaryTreeNode> stack = new Stack<P02_BinaryTreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            boolean tag = true;
            P02_BinaryTreeNode preNode = null;  // 前驱节点
            while (!stack.isEmpty() && tag == true) {
                treeNode = stack.peek();
                if (treeNode.rightChild == preNode) { // 之前访问的为空节点或是栈顶节点的右子节点
                    treeNode = stack.pop();
                    System.out.print(treeNode.data+" ");
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        preNode = treeNode;
                    }
                } else {
                    treeNode = treeNode.rightChild;
                    tag = false;
                }
            }
        }
    }

    //双栈法，易于理解
    //原文链接：https://blog.csdn.net/wayne566/article/details/79106372
    public static void postOrder3(P02_BinaryTreeNode p) {
        if (p == null) return;
        Stack<P02_BinaryTreeNode> stack = new Stack<P02_BinaryTreeNode>();
        Stack<P02_BinaryTreeNode> result = new Stack<P02_BinaryTreeNode>();
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                result.push(p);
                p = p.rightChild;
            }
            if (!stack.empty()) p = stack.pop().leftChild;
        }
        while (!result.empty()) {
            p = result.pop();
            System.out.print(p.data+" ");
        }
    }
}