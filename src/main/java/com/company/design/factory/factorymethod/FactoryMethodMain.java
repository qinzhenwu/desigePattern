package com.company.design.factory.factorymethod;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 工厂方法入口
 * <p>
 * 工厂方法，有一个接口工厂，定义好需要生产的一种产品（抽象类或是接口）
 * 该抽象的产品有具体的子类
 * 生产每种具体产品的都有对应的一个工厂。
 */

public class FactoryMethodMain {

    public static void main(String[] args) {
        FactoryMethod carFactory = new CarFactory();//创建需要的工厂
        Movable car = carFactory.createMovable();
        car.go();

        FactoryMethod planFactory = new PlaneFactory();
        Movable plan = planFactory.createMovable();
        plan.go();

    }
}
