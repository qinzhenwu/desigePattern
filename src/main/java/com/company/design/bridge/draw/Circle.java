package com.company.design.bridge.draw;

/**
 * 圆形
 */
public class Circle extends Shape {

    public Circle(Color color){
        super.color=color;
    }

    @Override
    void draw() {
        color.draw();
        System.out.println("圆形");
    }
}
