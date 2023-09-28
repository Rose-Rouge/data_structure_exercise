package com.roserouge.linkedList;

public class IntSinglyLinkedList {

    private Node head = null;

    public int get(int index) {
        Node p = head;

        int pos = 0;
        while(p != null && pos != index) {
            p = p.next;
            pos++;
        }

        if (p == null) {
            throw new RuntimeException();
        }
        return p.data;
    }

    public Node findByValue(int value) {
        Node p = head;

        while(p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while(p != null && pos != index) {
            p = p.next;
            pos++;
        }

        return p;
    }

    public void add(int data) {
        Node newNode = new Node(data, null);

        if (head == null) {
            addHead(newNode);
        } else {
            addTail(newNode);
        }
    }

    private void addHead(Node newNode) {
        head = newNode;
    }

    private void addTail(Node newNode) {
        Node q = head;
        while(q.next != null) {
            q = q.next;
        }
        q.next = newNode;
    }

    /**
     * 判断是否是回文
     */
    public boolean palindrome() {
        if (head == null) {
            return false;
        }

        Node p = head;
        Node q = head;
        if (p.next == null){
            return true;
        }

        while(q.next != null && q.next.next != null){
            p = p.next;
            q = q.next.next;
        }
        Node leftLink;
        Node rightLink;
        if (q.next == null) {
            rightLink = p.next;
            leftLink = inverseLinkList(p).next;
            System.out.println("左边第一个节点" + leftLink.data);
            System.out.println("右边第一个节点" + rightLink.data);
        } else {
            rightLink = p.next;
            leftLink = inverseLinkList(p);
        }
        return TFResult(leftLink, rightLink);
    }

    public Node inverseLinkList(Node p){
        Node prev = null;
        Node r = head;
        System.out.println("z---" + r.data);
        Node next = null;
        while (r != p) {
            next = r.next;

            r.next = prev;
            prev = r;
            r = next;
        }
        r.next = prev;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;
    }

    //判断true or false
    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;

        boolean flag = true;
        System.out.println("left_: " + l.data);
        System.out.println("right_: " + r.data);
        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int data) {
        return new Node(data, null);
    }

    public static class Node {
        private int data;

        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }
}
