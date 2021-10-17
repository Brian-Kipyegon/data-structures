package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BST<String> test = new BST<>();
        test.add("Hello");
        test.add("Happy");
        test.add("Val");
        test.add("Trance");
        test.levelOrderTraversal();
        Queue <String> tester = new Linkedlist<>();
        tester.enqueue("Hello");
        tester.enqueue("Happy");
        tester.enqueue("Vim");
        tester.dequeue();
        System.out.print(tester);
    }
}
