package com.company.design.factory.abstractfactory;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 牛肉食品
 */

public class Beef extends Food {
    @Override
    void sayName() {
        System.out.println("古代大侠的必备食物：二斤牛肉");
    }
}
