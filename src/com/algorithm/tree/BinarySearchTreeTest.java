package com.algorithm.tree;

import com.algorithm.tree.BinaryTree.BinaryTreeNode;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinaryTree.BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
		node.element = 6;
		BinarySeachTree<Integer> binarySeachTree = new BinarySeachTree<>(node);
		node = new BinaryTreeNode<>();
		node.element = 2;
		binarySeachTree.insert(node);
		node = new BinaryTreeNode<>();
		node.element = 8;
		binarySeachTree.insert(node);
		node = new BinaryTreeNode<>();
		node.element = 1;
		binarySeachTree.insert(node);
		node = new BinaryTreeNode<>();
		node.element = 4;
		binarySeachTree.insert(node);
		node = new BinaryTreeNode<>();
		node.element = 3;
		binarySeachTree.insert(node);
		binarySeachTree.inOrderTraversal(binarySeachTree.getRoot());
		System.out.println(binarySeachTree.findMax().element);
		System.out.println(binarySeachTree.findMin().element);
		System.out.println(binarySeachTree.contains(node));
		node = new BinaryTreeNode<>();
		node.element = 100;
		System.out.println(binarySeachTree.contains(node));
		node = new BinaryTreeNode<>();
		node.element = 2;
		System.out.println(binarySeachTree.remove(node).element);
		binarySeachTree.inOrderTraversal(binarySeachTree.getRoot());

	}
}
