package com.company.design.singleton;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description  枚举单例模式可以防止反序列化创建实例对象，因为枚举类没有构造函数
 */

public enum EnumSingleton {

    INSTANCE;

    public void m() {

    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(EnumSingleton.INSTANCE.hashCode());
            }).start();
        }
    }

}
