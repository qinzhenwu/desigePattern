package com.company.design.strategy.v1;

import java.math.BigDecimal;

public class CountPrice {


    public double getPrice(PriceCacle priceCacle) {
        return priceCacle.count(BigDecimal.valueOf(50));
    }


    public static void main(String[] args) {
        CountPrice c = new CountPrice();
        //PriceCacle vip = new VipPrice();
        PriceCacle vip = new NonVipPrice();
        double d = c.getPrice(vip);
        System.out.println(d);
    }
}
