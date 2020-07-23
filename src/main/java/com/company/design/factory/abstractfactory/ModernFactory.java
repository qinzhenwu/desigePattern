package com.company.design.factory.abstractfactory;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 现代的工厂，生产现代的食物和交通工具
 */

public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
