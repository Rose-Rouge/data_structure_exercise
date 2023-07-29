package com.roserouge.array;

import java.util.Arrays;

/**
 * 数组中的数据是int类型的
 */
public class IntArray {
    // 整型数组保存的数据
    private int[] data;

    // 数组长度
    private int length;

    // 数组实际个数
    private int size;

    private static final int DEFAULT_SIZE = 10;

    private static final int EXPANSION_SIZE = 2;

    /**
     * 构造方法，自定义数组长度
     * @param capacity  数组长度
     */
    public IntArray(int capacity) {
        this.data = new int[capacity];
        this.length = capacity;
        this.size = 0;
    }

    /**
     * 构造方法，默认长度 10
     */
    public IntArray() {
        this(DEFAULT_SIZE);
    }

    public int get(int index) {
        indexCheck(index);

        return data[index];
    }

    public void add(int value) {
        int index = size;
        boolean canAdd = indexCheckForAdd(index);

        if (canAdd) {
            data[index] = value;
            size++;
        } else {
            int[] newData = new int[EXPANSION_SIZE * length];
            for (int i = 0; i <= length; i++) {
                newData[i] = data[i];
            }
            newData[length] = value;

            data = newData;
            length = EXPANSION_SIZE * length;
            size++;
        }
    }

    public int getLength() {
        return length;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public boolean indexCheckForAdd(int index) {
        return index > 0 || index < length;
    }

    public void indexCheck(int index) {
        if (index < 0 || index >= length) {
            throw new RuntimeException(indexErrorMsg(index));
        }
    }

    public String indexErrorMsg(int index) {
        return "index: " + index + ",length: " + length + ",size: " + size;
    }
}

