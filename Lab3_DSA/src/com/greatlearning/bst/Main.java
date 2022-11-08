package com.greatlearning.bst;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size the tree:");
		int size = sc.nextInt();
		int value;
		Node root = null;
		System.out.println("Enter the numebrs you want to add to the tree:");
		for (int i = 0; i < size; i++) {
			value = sc.nextInt();
			if (root == null) {
				root = TreeOperations.insertNode(root, value);
			} else {
				TreeOperations.insertNode(root, value);
			}
		}
		System.out.println("Please enter the sum:");
		int sum = sc.nextInt();
		// traversing through the tree
		Deque<Node> q = new LinkedList<Node>();
		q.push(root);
		int result = 0;
		while (!q.isEmpty()) {
			Node node;
			node = q.remove();
			int diff = sum - node.data;
			result = TreeOperations.search(root, diff);

			if (result != -1 && result != node.data) {
				System.out.println("(" + node.data + "," + result + ")");
				break;
			}
			if (result == node.data) {
				result = -1;
			}
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
		if (result == -1) {
			System.out.println("No pair found!!");
		}
		sc.close();
	}

}
