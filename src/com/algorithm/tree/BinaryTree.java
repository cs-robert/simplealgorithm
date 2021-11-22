package com.algorithm.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 *
 * @param <T>
 * @author chao
 */
public class BinaryTree<T> {
    protected BinaryTreeNode<T> root;

    protected static class BinaryTreeNode<T> {
        protected T element;
        protected BinaryTreeNode<T> left;
        protected BinaryTreeNode<T> right;
        protected int hintcount;

        public BinaryTreeNode(T element) {
            this(element, null, null);
        }

        public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
            this.element = element;
            this.right = right;
            this.left = left;
        }
    }

    public BinaryTree(T root) {
        if (root != null) {
            this.root = new BinaryTreeNode<T>(root);
        }

    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    /**
     * 中序遍历LDR
     */
    protected void inOrderTraversal(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        } else {
            inOrderTraversal(node.left);
            printNode(node);
            inOrderTraversal(node.right);
        }
    }

    //按照层次遍历二叉树
    public void levelTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.remove();
            printNode(current);
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

    }

    /**
     * 非递归中序遍历LDR
     */
    protected void inOrderTraversal2(BinaryTreeNode<T> node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode<T> p = node;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                printNode(p);
                p = p.right;
            }
        }
    }

    public void firstOrderTraversal() {
        firstOrderTraversal(root);
    }

    /**
     * 先序遍历DLR
     */
    protected void firstOrderTraversal(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        } else {
            printNode(node);
            firstOrderTraversal(node.left);
            firstOrderTraversal(node.right);
        }
    }

    public void lastOrderTraversal() {
        lastOrderTraversal(root);
    }

    /**
     * 后序遍历LRD
     */
    protected void lastOrderTraversal(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        } else {
            lastOrderTraversal(node.left);
            lastOrderTraversal(node.right);
            for (int i = -1; i < node.hintcount; i++) {
                System.out.print(" " + node.element + " ");
            }
        }
    }

    public int getWidth() {
        return getWidth(root);
    }

    /**
     * 某个节点下的最大宽度
     *
     * @param node
     * @return
     */
    protected int getWidth(BinaryTreeNode<T> node) {
        if (node == null)
            return 0;

        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        int maxWitdth = 1; // 最大宽度
        queue.add(node); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                BinaryTreeNode t = queue.poll();
                len--;
                if (t.left != null)
                    queue.add(t.left); // 下一层节点入队
                if (t.right != null)
                    queue.add(t.right);// 下一层节点入队
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }

    public int getHeight() {
        return getHeight(root);
    }

    /**
     * 节点深度
     *
     * @param node
     * @return
     */
    protected int getHeight(BinaryTreeNode<T> node) {
        if (node == null)
            return 0;
        else {
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            return 1 + Math.max(left, right);
        }
    }

    /**
     * 打印结点信息
     *
     * @param node
     */
    protected void printNode(BinaryTreeNode<T> node) {
        for (int i = -1; i < node.hintcount; i++) {
            System.out.print(" " + node.element + " ");
        }
    }
}
