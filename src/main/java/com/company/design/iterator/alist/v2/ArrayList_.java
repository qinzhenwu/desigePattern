package com.company.design.iterator.alist.v2;

/**
 * iterator 模式主要用于容器和容器的遍历<br/>
 * v2 ArrayList 和 LinkedList都是迭代器模式，他们两个迭代的方式不同，ArrayList是数组，LinkedList是链表</br>
 * 为了统一他们对外提供的迭代能力，定义一个Iterator的接口，接口里有hasNext、next两个方法，ArrayList和LinkedList，自己去实现迭代的逻辑，只需要对外提供一个Iterator的方法
 * 即可，此方法返回Iterator的实现类，只需要调用此类的的hasNext、next就能完成遍历。</br>
 * 抽象一个容器的接口，定义iterator方法，ArrayList 和 LinkedList都去实现即可。
 */
public class ArrayList_ {

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        for (int i = 0; i < 15; i++) {
            a.add(i);
        }
        System.out.println(a);
        Iterator_ iterator_ = a.iterator();
        while (iterator_.hasNext()) {
            Object o = iterator_.next();
            System.out.println(o);
        }
    }
}


interface Collection {

    Iterator_ iterator();//迭代器方法

}

/**
 * 迭代器接口，实现类需要实现两个方法
 */
interface Iterator_ {
    boolean hasNext();//是否有下一个节点

    Object next();//下一个节点
}

/**
 * 实现集合接口
 */
class ArrayList implements Collection {

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


    @Override
    public Iterator_ iterator() {
        return new MyIterator();
    }

    /**
     * 此迭代器实现类只有ArrayList使用，因此定义为内部类
     */
    private class MyIterator implements Iterator_ {

        int index = 0;//遍历的下标

        @Override
        public boolean hasNext() {
            if (index < size)
                return true;
            return false;
        }

        @Override
        public Object next() {
            System.out.println("index" + index);
            Object o = array[index];
            index++;
            return o;
        }
    }
}
