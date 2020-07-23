package com.company.design.factory.abstractfactory;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 抽象工厂类，此类生产一些列的产品（多种）
 * <p>
 * 该类生成的产品都是抽象对象
 */

public abstract class AbstractFactory {

    /**
     * 生产食物方法
     *
     * @return
     */
    abstract Food createFood();

    /**
     * 生产交通工具的方法
     *
     * @return
     */
    abstract Vehicle createVehicle();
}
