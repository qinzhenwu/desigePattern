package com.company.design.strategy;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description
 */

public class MyCat {

    public MyCat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    private int weight;

    private int height;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "weight:" + this.weight + ",height=" + this.height;
    }
}
