package com.fawry.model.UserRelated.Concrete;

import com.fawry.model.UserRelated.Abstraction.User;

public class Customer extends User{

    public Customer(String name, String phone, String address, int age, String mail) {
        super(name,phone,address,age,mail);
    }

}
