package com.company.design.bridge.draw;

/**
 * @author 拌面
 * @date 2020/7/23
 * @description 画个方块
 */
public class Square extends Shape {

    public Square(Color color) {
        this.color = color;
    }

    @Override
    void draw() {
        this.color.draw();
        System.out.print("画方块");
    }
}
