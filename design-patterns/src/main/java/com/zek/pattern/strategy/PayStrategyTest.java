package pattern.strategy;

import pattern.strategy.payport.PayType;

public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1", "2018070700100009", 77.17);

        //开始支付，选择微信支付、支付宝、银联卡、京东白条、财付通
        //每个渠道它支付的具体算法是不一样的
        //基本算法固定的

        //这个值是在支付的时候才决定用哪个值

        System.out.println(order.pay(PayType.WECHAT_PAY));
    }
}
