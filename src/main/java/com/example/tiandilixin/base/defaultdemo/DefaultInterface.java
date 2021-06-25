package com.example.tiandilixin.base.defaultdemo;

public interface DefaultInterface {
   default void say(){
       System.out.println("Hi");
   }
   void eat();
}
