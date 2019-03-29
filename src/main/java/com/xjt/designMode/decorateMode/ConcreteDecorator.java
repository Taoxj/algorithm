package com.xjt.designMode.decorateMode;

/**
 * 具体的装饰角色
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void sampleOperation() {
        // 加点装饰
        System.out.println("装饰了！！！！");
        super.sampleOperation();

    }
}
