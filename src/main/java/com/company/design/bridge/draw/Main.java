package com.company.design.bridge.draw;

public class Main {
    public static void main(String[] args) {
        Shape c=new Circle(new Green());
        c.draw();
    }
}
