package com.company.design.factory.abstractfactory;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 古代的工厂类，生产古代的食物和交通工具
 */

public class OldenFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Beef();
    }

    @Override
    Vehicle createVehicle() {
        return new Carriage();
    }
}
