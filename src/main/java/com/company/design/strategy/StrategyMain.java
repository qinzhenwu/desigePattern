package com.company.design.strategy;

import java.util.Arrays;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description 策略模式入口
 */

public class StrategyMain {


    public static void main(String[] args) {

        //创建数组
        MyCat[] arr = {new MyCat(10, 20), new MyCat(15, 22), new MyCat(9, 12)};
        //创建排序对象
        Sort<MyCat> myCatSort = new Sort<>();
        //传入数组和比较器进行比较，比较策略在比较器中实现
        //myCatSort.sortArray(arr, new CatComparator());
        myCatSort.sortArray(arr, (t1, t2) -> {
            if (t1.getWeight() - t2.getWeight() > 0) {
                return 1;
            } else if (t1.getWeight() - t2.getWeight() < 0) {
                return -1;
            } else {
                return 0;
            }//Lambda实现方式，接口类中只有一个方法，或者只有一个方法没有default方法修饰*有且只有一个抽象方法的接口*
        });
        System.out.println(Arrays.toString(arr));
    }
}
