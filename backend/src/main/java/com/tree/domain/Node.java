package com.tree.domain;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public int data;
	public Node left;
	public Node right;

	private List<Integer> path1 = new ArrayList<>();
	private List<Integer> path2 = new ArrayList<>();

	public Node() {
		data = 0;
		left = null;
		right = null;
	}

	public void add(int data) {
		if (this.data == 0) {
			this.data = data;
		} else {
			if (data > this.data) {
				if (this.right == null) {
					this.right = new Node();
				}
				this.right.add(data);
				return;
			}
			if (data < this.data) {
				if (this.left == null) {
					this.left = new Node();
				}
				this.left.add(data);
			}
		}
	}

	public void inOrder() {
		if (this.left != null) {
			this.left.inOrder();
		}
		System.out.print(this.data + ", ");
		if (this.right != null) {
			this.right.inOrder();
		}
	}

	public int ancestor(int node1, int node2) {
		path1.clear();
		path2.clear();
		return internalAncestor(this, node1, node2);
	}

	private int internalAncestor(Node root, int n1, int n2) {
		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
			return -1;
		}
		int i = 0;
		while (i < path1.size() && i < path2.size()) {
			if (!path1.get(i).equals(path2.get(i))) {
				break;
			}
			i++;
		}
		return path1.get(i - 1);
	}

	private boolean findPath(Node root, int n, List<Integer> path) {
		if (root == null) {
			return false;
		}

		path.add(root.data);

		if (root.data == n) {
			return true;
		}

		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

		path.remove(path.size() - 1);
		return false;
	}
}
