package com.company.design.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 懒加载，对getInstance方法上锁，保证只创建一个实例对象.但是会存在一些 效率问题。
 */

public class Lazy_Sync_Safe {

    private Lazy_Sync_Safe() {

    }

    private static Lazy_Sync_Safe instance;

    private static synchronized Lazy_Sync_Safe getInstance() {
        if (instance == null) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Lazy_Sync_Safe();
        }
        return instance;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            new Thread(() -> {
                Lazy_Sync_Safe lazy_sync_safe = Lazy_Sync_Safe.getInstance();
                System.out.println(lazy_sync_safe.hashCode());
            }).start();
        }
    }
}
