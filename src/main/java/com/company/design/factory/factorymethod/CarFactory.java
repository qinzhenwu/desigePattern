package com.company.design.factory.factorymethod;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 汽车工厂类
 */

public class CarFactory implements FactoryMethod{
    @Override
    public Movable createMovable() {
        return new M_Car();
    }
}
