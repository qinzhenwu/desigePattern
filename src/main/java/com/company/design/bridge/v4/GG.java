package com.company.design.bridge.v4;

public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }

    public void give(MM mm, Gift g) {
        System.out.println(g + "gived!");
    }

    public static void main(String[] args) {
        GG g=new GG();
        MM mm=new MM();
        g.chase(mm);
    }
}
