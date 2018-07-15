package com.zek.pattern.strategy.payport;


import com.zek.pattern.strategy.PayState;

public interface Payment {

    PayState pay(String uid, double amount);
}
