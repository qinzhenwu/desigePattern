package com.company.design.builder;

/**
 * 地形构造器接口，定义成接口可以根据不同的需求实现具体的构造器。如简单的地形，复杂的地形。
 */
public interface TerrainBuilder {
    TerrainBuilder buildWall();
    TerrainBuilder buildFort();
    TerrainBuilder buildMine();
    Terrain build();
}
