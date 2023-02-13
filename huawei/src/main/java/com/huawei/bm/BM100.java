package com.huawei.bm;

import java.util.HashMap;
import java.util.Map;

public class BM100 {
    int size = 0;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public static void main(String[] args) {
        BM100 lru = new BM100(2);
        lru.set(1, 1);
        lru.set(2, 2);
        System.out.println(lru.get(1));
        lru.set(3, 3);
        System.out.println(lru.get(2));
        lru.set(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }

    public BM100(int capacity) {
        map = new HashMap(capacity);
        size = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    private class Node {
        Node pre;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToFirst(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node;
        if (!map.containsKey(key)) {
            node = new Node(key, value);
            if (size < 0) {
                removeLast();
            } else {
                size--;
            }

            insertFirst(node);
        } else {
            node = map.get(key);
            node.value = value;
            moveToFirst(node);
        }

        map.put(key, node);


    }

    private void removeLast() {
        map.remove(tail.pre.key);
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;

    }

    private void moveToFirst(Node node) {
        if (node.pre == head) {
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;

        insertFirst(node);

    }

    private void insertFirst(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

}
