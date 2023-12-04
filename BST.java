package Lap11;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public void setRoot(BNode<E> root) {
		this.root = root;
	}

	// Task 1
	// Add element e into BST
	public void add(E e) {
		if (this.root == null)
			this.setRoot(new BNode<>(e));
		else
			this.root.add(this.root, e);
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col)
			add(e);
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		BNode<E> currentNode = this.root.search(this.root, node);
		return (currentNode != null) ? currentNode.findDepth(currentNode) : -1;
	}

	// compute the height of BST
	public int height() {
		return this.root.findDepth(this.root);
	}

	// Compute total nodes in BST
	public int size() {
		return this.root.countSize(this.root);
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		return this.root.search(this.root, e) != null;
	}

	// Find the minimum element in BST
	public E findMin() {
		return this.root.findMinWithBranch(this.root);
	}

	// Find the maximum element in BST
	public E findMax() {
		return this.root.findMaxWithBranch(this.root);
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (this.root.getData().compareTo(e) == 0) {
			this.setRoot(this.root.removeRoot(e));
			return true;
		} else
			return this.root.remove(e);
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		BNode<E> currentNode = this.root.search(this.root, data);
		return (currentNode == null) ? null : currentNode.addDescendants(currentNode, currentNode.getData());
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		return (this.root.search(this.root, data) == null) ? null : this.root.addAncestors(data);
	}

	// Task 2
	public void inorder() {
		this.root.inorderPrint(this.root);
	}

	public void preorder() {
		this.root.preorderPrint(this.root);
	}

	public void postorder() {
		this.root.postorderPrint(this.root);
	}

	public static void main(String[] args) {
		BST<Integer> tree = new BST<>();
		tree.add(17);
		tree.add(13);
		tree.add(15);
		tree.add(14);
		tree.add(20);
		tree.add(10);
		tree.add(2);
		tree.add(3);
		tree.add(9);
		tree.add(30);
		tree.add(40);
		tree.add(33);
		tree.add(1);
		tree.add(21);
		tree.add(4);
		tree.add(25);
		tree.add(42);
		tree.inorder();
		System.out.println();
		tree.preorder();
		System.out.println();
		tree.postorder();
		System.out.println();
		System.out.println(tree.descendants(15));
		System.out.println(tree.ancestors(90));
		System.out.println(tree.contains(25));
		System.out.println(tree.contains(100000));
		System.out.println(tree.depth(25));
		System.out.println(tree.depth(90));
		System.out.println(tree.height());
		System.out.println(tree.depth(15));
		System.out.println(tree.size());
		System.out.println(tree.remove(25));
		System.out.println(tree.remove(50));
		System.out.println(tree.remove(1000));
		System.out.println(tree.size());
		tree.inorder();
		System.out.println();
		System.out.println(tree.findMin());
		System.out.println(tree.findMax());

	}
}
