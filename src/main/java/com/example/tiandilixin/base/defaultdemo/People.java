package com.example.tiandilixin.base.defaultdemo;

public class People implements DefaultInterface {

    @Override
    public void eat() {
        System.out.println("eat");
    }

    public static void main(String[] args) {
        People people=new People();
        people.say();
        people.eat();
    }
}
