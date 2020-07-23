package com.company.design.proxy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 静态代理,代理类和被代理类同时实现一个接口，可以实现代理类之间的嵌套<br/>
 * 如果使用集成的方式实现代理，如果要实现多个代理效果，会创建很多类。
 */
public class StaticProxy {

    public static void main(String[] args) {
        TankLogProxy tankLogProxy = new TankLogProxy(new TankTimeProxy(new Tank()));
        tankLogProxy.move();
    }
}


interface Movable {
    void move();//移动方法
}

class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("moving .........");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TankLogProxy implements Movable {

    private Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }


    @Override
    public void move() {
        System.out.println("开始移动");
        movable.move();
        System.out.println("停止移动");
    }
}

class TankTimeProxy implements Movable {

    private Movable movable;

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }


    @Override
    public void move() {
        Long begin = System.currentTimeMillis();
        movable.move();
        Long end = System.currentTimeMillis();
        System.out.println("移动耗时" + (end - begin));
    }
}