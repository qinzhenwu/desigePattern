package com.company.design.iterator.llist.v1;

public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 16; i++) {
            linkedList.add(i);
        }
        System.out.println(linkedList.size);
    }

}


class LinkedList {
    Node head;//头节点
    Node tail;//尾节点

    int size = 0;//冗余字段，list的长度

    public void add(Object o) {
        if (head == null) {
            Node node = new Node(o);
            head = node;
            tail = node;//首次插入，头结点和尾节点是同一个
        } else {
            Node node = new Node(o);
            tail.next = node;//将原有尾节点的下一个节点指向新增的节点。
            tail = node;//将新增节点设置为尾节点
        }
        size++;
    }


}

class Node {
    Node next;//指向的下一个节点
    Object value;//当前节点的值

    public Node(Object o) {
        this.value = o;
    }
}
