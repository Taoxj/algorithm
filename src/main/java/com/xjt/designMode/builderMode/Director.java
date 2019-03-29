package com.xjt.designMode.builderMode;

/**
 * 指挥者
 */
public class Director {

    public Product constructProduct(ConcreteBuilder concreteBuilder) {
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }
}
