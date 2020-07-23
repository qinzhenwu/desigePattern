package com.company.design.factory.simple;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description
 */

public class SimpleMain {


    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();//创建工厂类，
        SimpleCar car = factory.createCar();//通过工厂类创建car对象
        car.run();
    }

}
