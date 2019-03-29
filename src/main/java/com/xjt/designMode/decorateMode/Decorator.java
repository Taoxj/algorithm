package com.xjt.designMode.decorateMode;

/**
 * 装饰角色
 */
public class Decorator implements Component{

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    public void sampleOperation() {
        // 委派给构件角色
        component.sampleOperation();
    }
}
