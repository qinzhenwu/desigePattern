package com.company.design.factory.factorymethod;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 飞机对象, 实现Movable接口和方法
 */

public class M_Plane implements Movable {

    @Override
    public void go() {
        System.out.println("Plane gogo...");
    }
}
