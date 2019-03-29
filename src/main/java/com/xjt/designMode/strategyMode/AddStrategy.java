package com.xjt.designMode.strategyMode;

/**
 * 具体的策略角色，加法
 */
public class AddStrategy implements Strategy {

    public int cal(int num1, int num2) {
        return num1 + num2;
    }
}
