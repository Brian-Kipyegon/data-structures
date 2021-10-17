package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E  extends Comparable<E>> {
    //Root node
    private  Node root;
    private int nodeCount = 0;

   //inner class to represent node objects
    class Node {
        private final E val;
        private Node leftNode;
        private  Node rightNode;

        Node(E val) {
            this.val = val;
        }

        Node (E val, Node left, Node right) {
            this.val = val;
            this.leftNode= left;
            this.rightNode = right;
        }
        public  void visit() {
            System.out.print(val);
        }
        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

   //Constructor
    BST() {}

   //Adds an element to the binary search tree.
    public boolean add(E data) {
        Node newNode = new Node(data);
        if (root  == null) {
            root = newNode;
            nodeCount++;
            return  true;
        }
        Node current = root;
        while (true) {
            if (data.compareTo(current.val) > 0)  {
                if (current.rightNode == null) break;
                current = current.rightNode;
            } else  if (data.compareTo(current.val) < 0) {
                if (current.leftNode == null) break;
                current = current.leftNode;
            } else {
                return false;
            }
        }
        if (data.compareTo(current.val) > 0) current.rightNode = newNode;
        else current.leftNode = newNode;
        nodeCount++;
        return true;
    }

    //Calls recursive adder
    public boolean recursiveAdder(E data) {
        if (this.contains(data)) return false;
        else {
            add(root, data);
            return true;
        }
    }

    public void add(Node root, E data) {
        Node curr = root;
        if (curr == null) {
            curr = new Node(data);
        } else {
            if (data.compareTo(curr.val) > 0) add(curr.leftNode, data);
            else if (data.compareTo(curr.val) < 0) add(curr.rightNode, data);
        }
    }

    //Removes a Node from the BST
    public Node remove(E data) {
        Node removedNode = null;

        return removedNode;
    }

    public boolean contains(E data) {
        Node curr = root;
        while (curr != null) {
            if (data.compareTo(curr.val) > 0) curr = curr.rightNode;
            else if (data.compareTo(curr.val) < 0) curr = curr.leftNode;
            else return  true;
        }
        return false;
    }

    //Checks whether the tree has no elements.
    public boolean isEmpty() { return  root == null; }

    //Returns the size of the binary search tree
    public int size() { return  nodeCount; }

   //Does a preorder traversal
    public  void preorder(Node node) {
        if (node == null) return;
        node.visit();
        preorder(node.leftNode);
        preorder(node.rightNode);
    }

    //Does a inorder traversal
    private  void  inorder(Node node) {
        if (node == null) return;
        inorder(node.leftNode);
        node.visit();
        inorder(node.rightNode);
    }

    //Does a postorder traversal
    private  void  postorder(Node node) {
        if (node == null) return;
        postorder(node.leftNode);
        postorder(node.rightNode);
        node.visit();
    }

   //Does a breadth first search
    public void levelOrderTraversal()  {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            if (curr.leftNode != null) {
                queue.add(curr.leftNode);
            }
            if (curr.rightNode != null) {
                queue.add(curr.rightNode);
            }
            curr.visit();
        }
    }

    public void inorderTraversal() {
        preorder(root);
    }

    @Override
    public String toString() {
        return "BST{" +
                "rootNode=" + root +
                '}';
    }
}

