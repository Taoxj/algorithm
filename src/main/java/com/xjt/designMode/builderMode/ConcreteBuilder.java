package com.xjt.designMode.builderMode;

/**
 * 具体的建造者
 */
public class ConcreteBuilder implements Builder {

    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    public void buildBasic() {
        product.setBasic("打好基础");
    }

    public void buildWalls() {
        product.setWall("砌墙");
    }

    public void roofed() {
        product.setRoofed("封顶大吉");
    }

    public Product buildProduct() {
        return product;
    }
}
