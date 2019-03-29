package com.xjt.designMode.strategyMode;

/**
 * 环境角色
 */
public class Environment {

    // 持有对策略类的引用
    private Strategy strategy;

    public Environment(Strategy strategy) {
        this.strategy = strategy;
    }

    public int cal(int num1, int num2) {
        return strategy.cal(num1, num2);
    }
}
