package com.company.design.strategy;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 比较器, 不同的实现类里去实现比较方法，调用的时候直接给定类型即可
 */

public interface MyComparator<T> {

    int compare(T t1, T t2);
}
