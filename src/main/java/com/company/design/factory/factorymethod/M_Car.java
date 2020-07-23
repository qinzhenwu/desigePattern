package com.company.design.factory.factorymethod;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 汽车对象
 */

public class M_Car implements Movable {
    @Override
    public void go() {
        System.out.println("car gogo...");
    }
}
