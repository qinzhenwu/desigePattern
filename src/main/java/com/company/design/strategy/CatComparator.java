package com.company.design.strategy;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 该比较器时比较重量，可以再实现一个比较器，比较高度，方便扩展。
 */

public class CatComparator implements MyComparator<MyCat> {

    /**
     * 按照重量比较
     *
     * @param t1
     * @param t2
     * @return
     */
    @Override
    public int compare(MyCat t1, MyCat t2) {
        if (t1.getWeight() - t2.getWeight() > 0) {
            return 1;
        } else if (t1.getWeight() - t2.getWeight() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
