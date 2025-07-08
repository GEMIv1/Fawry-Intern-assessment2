package com.fawry.model.UserRelated.Abstraction;

public abstract class User {
    private String name;
    private String phone;
    private String address;
    private int age;
    private String mail;

    public User(String name, String phone, String address, int age, String mail) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.mail = mail;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public String getMail(){
        return mail;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
