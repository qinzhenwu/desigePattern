package com.company.design.strategy.v1;

import java.math.BigDecimal;

public class NonVipPrice implements PriceCacle{
    @Override
    public double count(BigDecimal price) {
        return price.doubleValue() * 0.95;
    }
}
