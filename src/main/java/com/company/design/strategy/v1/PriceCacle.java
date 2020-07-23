package com.company.design.strategy.v1;

import java.math.BigDecimal;

/**
 * 价格计算器
 */
public interface PriceCacle {

    double count(BigDecimal price);

}
