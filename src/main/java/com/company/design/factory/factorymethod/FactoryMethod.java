package com.company.design.factory.factorymethod;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 工厂方法借口类，定义需要生产的产品，具体的产品如何生产以及具体的产品是什么有子类来实现。
 * 工厂方法可以很方便的扩展需要生产的具体产品，子需要实现该接和方法，创建具体的工厂类即可，但是只生产一种类型的产品。
 */

public interface FactoryMethod {

    Movable createMovable();//子类实现，创建哪种具体的产品
}
