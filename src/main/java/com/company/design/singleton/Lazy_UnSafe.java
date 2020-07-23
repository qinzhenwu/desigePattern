package com.company.design.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 懒汉式，多线程并发情况下会创建多个实例
 */

public class Lazy_UnSafe {

    private Lazy_UnSafe() {

    }

    private static Lazy_UnSafe lazy_unSafe;


    private static Lazy_UnSafe getInstance() {
        if (lazy_unSafe == null) {
            try {
                TimeUnit.SECONDS.sleep(1);//睡眠一毫秒，模拟创建耗时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazy_unSafe = new Lazy_UnSafe();
        }
        return lazy_unSafe;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Lazy_UnSafe.getInstance().hashCode());

                }
            }).start();
        }
    }
}
