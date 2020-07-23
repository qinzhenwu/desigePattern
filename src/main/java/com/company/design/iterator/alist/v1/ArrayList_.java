package com.company.design.iterator.alist.v1;

/**
 * iterator 模式主要用于容器和容器的遍历<br/>
 * v1简单实现arrayList的add
 */
public class ArrayList_ {

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        for (int i = 0; i < 15; i++) {
            a.add(i);
        }
        System.out.println(a);
    }
}


/**
 * 实现集合接口
 */
class ArrayList {

    private Object[] array = new Object[10];

    private int size;//数组大小

    public void add(Object object) {
        if (size >= array.length) {//需要扩容
            System.out.println(String.format("size:{%s},length:{%s}", size, array.length));
            Object[] newArray = new Object[array.length * 2];//直接扩容2倍
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = object;

    }


}
