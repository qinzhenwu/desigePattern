package com.company.design.singleton;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 饿汉式单例, 类加载到内存后，就实例化一个单例，JVM保证线程安全性
 * 唯一缺点，不管使用与否，都会创建一个实例。
 * 可以通过反射的方式创建多个实例
 */

public class HungrySingleton {

    /**
     * 私有化构造方法，防止新建
     */
    private HungrySingleton() {

    }

    private static final HungrySingleton instance = new HungrySingleton();

    private static HungrySingleton getInstance() {
        return instance;
    }


    public static void main(String[] args) {
/**
 * 验证线程安全性
 */
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                HungrySingleton singleton = HungrySingleton.getInstance();
//                HungrySingleton s=new HungrySingleton();
                System.out.println(singleton.hashCode());
            }).start();
        }


    }

}
