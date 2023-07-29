package com.roserouge;

import com.roserouge.array.IntArray;
import org.junit.jupiter.api.Test;

public class testIntArray {

    @Test
    void test() {
        IntArray intArray = new IntArray(5);
        intArray.add(354);
        intArray.add(1354);
        intArray.add(14);
        intArray.add(0);
        System.out.println("length = " + intArray.getLength());
        System.out.println("size = " + intArray.getSize());
        System.out.println("intArray = " + intArray);
    }
}
