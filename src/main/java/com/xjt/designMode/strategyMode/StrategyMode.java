package com.xjt.designMode.strategyMode;

/**
 * 策略模式
 */
public class StrategyMode {

    /**
     * 其思想是针对一组算法，将每一种算法都封装到具有共同接口的独立的类中，从而是它们可以相互替换。
     * 策略模式的最大特点是使得算法可以在不影响客户端的情况下发生变化，从而改变不同的功能。
     */

    /**
     * 组成：
     * 抽象策略角色：这个是一个抽象的角色，通常情况下使用接口或者抽象类去实现。
     * 具体策略角色：包装了具体的算法和行为。
     * 环境角色内部会持有一个抽象角色的引用，给客户端调用。
     */

    public static void main(String[] args) {
        // 传入具体的策略类
        Environment environment = new Environment(new AddStrategy());
        int result = environment.cal(20, 30);
        System.out.println(result);

    }
}
