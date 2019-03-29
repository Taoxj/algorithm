package com.xjt.designMode.strategyMode;

/**
 * 具体的策略角色，减法
 */
public class SubtractStrategy implements Strategy {
    public int cal(int num1, int num2) {
        return num1 - num2;
    }
}
