package com.company.design.factory.abstractfactory;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 抽象工厂
 */

public class AbFaMain {
    public static void main(String[] args) {

        AbstractFactory modern = new ModernFactory();
        Food mf = modern.createFood();
        Vehicle mv = modern.createVehicle();
        mf.sayName();
        mv.go();

        AbstractFactory ofactory = new OldenFactory();
        Food of = ofactory.createFood();
        Vehicle ov = ofactory.createVehicle();

        of.sayName();
        ov.go();

    }
}
