package com.company.design.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 在创建实例时上锁，不再整个方法上锁；
 * 实例对象使用volatile修饰，防止指令重排序，返回半初始化的状态。
 * jvm只会加载一次class，因此锁住class，保证锁住了一个门。
 */

public class Lazy_Sync_Generate {

    private Lazy_Sync_Generate() {

    }

    private static volatile Lazy_Sync_Generate instance;

    /**
     * DCL double check lock，双重检查锁定
     * 在第一次判断实例是否为空时可能存在多个线程同时进行了判断，然后执行创建时使用了锁；多个线程会等待第一拿到锁的线程处理完再处理，
     * 这是在锁里再进行一次非空的判断，会把其他线程创建的对象取到。从而保证只有一个对象实例。
     *
     * @return
     */
    private static Lazy_Sync_Generate getInstance() {
        if (instance == null) {
            synchronized (Lazy_Sync_Generate.class) {
                if (instance == null) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Lazy_Sync_Generate();
                }
            }

            //1212313
        }
        return instance;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 80; i++) {
            new Thread(() -> {
                Lazy_Sync_Generate instance = Lazy_Sync_Generate.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
