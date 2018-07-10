package com.zek.serial;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getName() {
        User user = new User();
        user.setName("zek");
        System.out.println(user.getName());
    }
}