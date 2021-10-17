package com.company;

public class Linkedlist <T> implements Queue <T>, Stack <T> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    class Node {
        private T data;
        private Node nextNode = null;
        private Node prevNode = null;

        public Node(T data) {
            this.setData(data);
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String toString() {
            return "Node : data->" + this.data;
        }

    }

    public void addFirst(T data) {
        Node new_Node = new Node(data);
        if (this.head == null) {
            this.head = new_Node;
            this.tail = new_Node;
        } else {
            new_Node.setNextNode(this.head);
            this.head.setPrevNode(new_Node);
            this.head = new_Node;
        }
        size++;
    }

    public void addLast(T data) {
        Node new_Node = new Node(data);
        if (this.tail == null) {
            this.tail = new_Node;
            this.head = new_Node;
        } else {
            new_Node.setPrevNode(this.tail);
            this.tail.setNextNode(new_Node);
            this.tail = new_Node;
        }
        size++;
    }

    public void add(T data) {
        addLast(data);
    }

    public void add(int index, T data) {
        if (head == null || tail ==null) {
            addFirst(data);
            return;
        }
        Node curr_Node;
        if (index < (size / 2)) {
            curr_Node = head;
            for (int i = 0; i < index; i++) {
                curr_Node = curr_Node.getNextNode();
            }
        } else {
            curr_Node = tail;
            for (int i = size; i > index; i--) {
                curr_Node = curr_Node.getPrevNode();
            }
        }
        Node new_Node = new Node(data);
        new_Node.setNextNode(curr_Node.getNextNode());
        curr_Node.getNextNode().setPrevNode(new_Node);
        new_Node.setPrevNode(curr_Node);
        curr_Node.setNextNode(new_Node);
        size++;
    }

    public T remove(T data) {
        Node currNode = head;

        while(currNode!= null) {
            if (currNode.getData() == data) {
                break;
            }
            currNode = currNode.getNextNode();
        }
        Node nextNode = currNode.getNextNode();
        Node prevNode = currNode.getPrevNode();
        if (prevNode != null) {
            prevNode.setNextNode(nextNode);
        } else {
            head = nextNode;
        }
        if (nextNode != null) {
            nextNode.setPrevNode(prevNode);
        } else {
            tail = prevNode;
        }
        size--;
        return currNode.getData();
    }

    public T removeAt(int pos) {
        if (pos > size()) throw new IndexOutOfBoundsException();
        Node currNode = head;
        int index = 0;
        T data = null;
        while (currNode != null) {
            if (index == pos) {
                Node nextNode = currNode.getNextNode();
                Node prevNode = currNode.getPrevNode();
                if (prevNode != null) {
                    prevNode.setNextNode(nextNode);
                } else {
                    head = nextNode;
                }
                if (nextNode != null) {
                    nextNode.setPrevNode(prevNode);
                } else {
                    tail = prevNode;
                }
                data = currNode.getData();
                break;
            }
            currNode = currNode.getNextNode();
            index++;
        }
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(T data) {
        Node currNode = head;

        while(currNode!= null) {
            if (currNode.getData() == data) {
                return true;
            }
            currNode = currNode.getNextNode();
        }
        return false;
    }

    public void push(T data) {
        addFirst(data);
    }

    public T pop() {
        T data = removeAt(0);
        return data;
    }

    public T peek() {
        return head.getData();
    }

    public void enqueue(T data) {
        addLast(data);
    }

    public T dequeue() {
        T data = removeAt(0);
        return data;
    }

    @Override
    public String toString() {
        StringBuilder linkedlist = new StringBuilder("[");
        Node curr_Node = head;
        while (curr_Node != null) {
            if (curr_Node.getNextNode() != null) {
                linkedlist.append(curr_Node.getData()).append("-> ");
            } else {
                linkedlist.append(curr_Node.getData()).append("]");
            }
            curr_Node = curr_Node.getNextNode();
        }
        return linkedlist.toString();
    }

}
