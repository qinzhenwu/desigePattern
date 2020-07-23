package com.company.design.builder;

/**
 * 分离复杂对象的构建和表示
 *
 * 同样的构建过程可以创建不同的表示
 *
 * 无需记忆，自然使用
 *
 * 构建时可以根据实际需要选择性的构建，不需要构建的可以不处理
 */
public class BuilderMain {

    public static void main(String[] args) {
        Person p = new Person.PersonBuilder().baseInfo("qin", 23, "男").localInfo("苹果园大街","999号").build();
        System.out.println(p);

        Terrain terrain=new ComplexTerrainBuilder().buildFort().buildMine().build();

    }
}
