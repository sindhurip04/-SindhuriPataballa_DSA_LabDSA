package com.greatlearning.bst;

public class TreeOperations {

	// Method to create new node
	public static Node newNode(int data) {
		Node newnode = new Node();
		newnode.data = data;
		newnode.left = null;
		newnode.right = null;

		return newnode;
	}

	// Method to insert nodes into the tree
	public static Node insertNode(Node root, int data) {
		Node temp_node = newNode(data);
		Node x = root;
		Node curr_parent = null;

		while (x != null) {
			curr_parent = x;
			if (data > curr_parent.data) {
				x = curr_parent.right;
			} else if (data < curr_parent.data) {
				x = curr_parent.left;
			} else {
				System.out.println("Duplicate value not allowed.");
				return temp_node;
			}
		}
		// if root is null
		if (curr_parent == null) {
			curr_parent = temp_node;
		}
		// Assign new node node to left child
		else if (data < curr_parent.data) {
			curr_parent.left = temp_node;
		}
		// Assign new node node to right child
		else {
			curr_parent.right = temp_node;
		}
		return curr_parent;
	}

	// Returns value to main method
	public static int search(Node root, int diff) {
		root = searchRecursive(root, diff);
		if (root != null) {
			return root.data;
		} else {
			return -1;
		}
	}

	// Search value in the tree
	public static Node searchRecursive(Node root, int diff) {
		if (root == null || root.data == diff) {
			return root;
		} else if (diff < root.data) {
			return searchRecursive(root.left, diff);
		}
		return searchRecursive(root.right, diff);
	}
}
