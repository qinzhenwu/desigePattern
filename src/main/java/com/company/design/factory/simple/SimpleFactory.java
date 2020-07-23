package com.company.design.factory.simple;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 简单工厂类，简单的生成一个对象返回
 */

public class SimpleFactory {

    public SimpleCar createCar() {
        return new SimpleCar();
    }
}
