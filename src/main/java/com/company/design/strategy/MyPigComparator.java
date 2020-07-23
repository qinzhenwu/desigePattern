package com.company.design.strategy;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 自定义比较器，按照MyPig对象进行比较，具体内部的比较策略该比较器实现
 */

public class MyPigComparator implements MyComparator<MyPig> {
    @Override
    public int compare(MyPig t1, MyPig t2) {
        if (t1.getWeight() - t2.getWeight() > 0) {
            return 1;
        } else if (t1.getWeight() - t2.getWeight() < 0) {
            return -1;
        } else {
            return 0;
        }

    }
}
