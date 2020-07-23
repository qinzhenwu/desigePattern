package com.company.design.factory.simple;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 简单汽车
 */

public class SimpleCar {


    private int money;

    public void run() {
        System.out.println("mycar run run ....");
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
