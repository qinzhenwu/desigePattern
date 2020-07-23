package com.company.design.strategy.v1;

import java.math.BigDecimal;

public class VipPrice implements PriceCacle {
    @Override
    public double count(BigDecimal price) {
        return price.doubleValue() * 0.8;
    }
}
