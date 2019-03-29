package com.xjt.designMode.strategyMode;

/**
 * 抽象策略角色
 */
public interface Strategy {

    /**
     * 定义了两个数可以进行计算的方法
     */
    public int cal(int num1, int num2);
}
