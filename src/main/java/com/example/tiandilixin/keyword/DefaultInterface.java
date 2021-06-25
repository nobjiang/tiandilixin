package com.example.tiandilixin.keyword;

public interface DefaultInterface {
   default void say(){
       System.out.println("Hi");
   }
   void eat();
}
