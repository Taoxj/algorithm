package com.xjt.designMode.builderMode;

/**
 * 建造者模式
 */
public class BuilderMode {

    /**
     * 描述：
     * 建造者模式可以将部件和其组装过程分开，一步一步创建一个复杂的对象
     * 复杂对象相当于一幢房子，而对象的属性相当于房子的内部组件，建造产品的过程就相当于组合部件的过程(打地基，砌砖)。
     * 由于组合部件的过程很复杂，因此，这些部件的组合过程往往被“外部化”到一个称作建造者（工程师）的对象里，
     * 建造者返还给客户端的是一个已经建造完毕的完整产品对象，而用户无须关心该对象所包含的属性以及它们的组装方式，
     * 这就是建造者模式的模式动机。
     */

    /**
     * 模式结构
     * 建造者模式包含如下角色：
     * Builder：抽象建造者
     * ConcreteBuilder：具体建造者
     * Director：指挥者
     * Product：产品角色
     */

    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.constructProduct(new ConcreteBuilder());
        System.out.println(product.getBasic());
        System.out.println(product.getWall());
        System.out.println(product.getRoofed());
    }


}
