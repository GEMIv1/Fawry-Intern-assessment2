package com.fawry.model.UserRelated.Concrete;

import com.fawry.model.UserRelated.Abstraction.User;

public class Admin extends User{
    public Admin(String name, String phone, String address, int age, String mail){
        super(name,phone,address,age,mail);
    }
}
