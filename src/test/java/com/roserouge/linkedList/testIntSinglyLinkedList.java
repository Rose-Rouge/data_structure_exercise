package com.roserouge.linkedList;

import org.junit.jupiter.api.Test;

public class testIntSinglyLinkedList {

    @Test
    void test() {
        IntSinglyLinkedList intSinglyLinkedList = new IntSinglyLinkedList();
        int[] data = {1,2,2,1};
        for (int i = 0; i < data.length; i++) {
            intSinglyLinkedList.add(data[i]);
        }
        intSinglyLinkedList.printAll();

        int value = intSinglyLinkedList.get(2);
        System.out.println("value = " + value);

        boolean palindrome = intSinglyLinkedList.palindrome();
        System.out.println("palindrome = " + palindrome);
    }
}
