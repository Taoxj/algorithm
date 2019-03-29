package com.xjt.designMode.adapterMode;

/**
 * 适配器模式
 */
public class AdapterMode {
    /**
     * 定义：适配器模式将某个类的接口转换成客户端期望的另一个接口表示，
     * 主的目的是兼容性，让原本因接口不匹配不能一起工作的两个类可以协同工作。
     */

    /**
     *
     * 需要被适配的类、接口、对象（我们有的），简称 src（source）
     * 最终需要的输出（我们想要的），简称 dst (destination，即Target)
     * 适配器称之为 Adapter 。
     *
     * 用生活中充电器的例子来讲解适配器，充电器本身相当于Adapter，220V交流电相当于src，我们的目dst标是5V直流电。
     */

    public static void main(String[] args) {
        VoltageAdapter voltageAdapter = new VoltageAdapter(new Voltage220());
        System.out.println(voltageAdapter.output5V());
    }
}
