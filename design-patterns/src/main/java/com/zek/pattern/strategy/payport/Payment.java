package com.zek.pattern.strategy.payport;

import pattern.strategy.PayState;

public interface Payment {

    PayState pay(String uid, double amount);
}
