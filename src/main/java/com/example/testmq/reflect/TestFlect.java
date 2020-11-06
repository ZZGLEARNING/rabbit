package com.example.testmq.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestFlect {

    public static void main(String[] args) {
        //获去class对象

        try {

            Class clazz= Class.forName("com.example.testmq.reflect.Person");
            //获去成员变量
            Person person= new Person();
            UserService userService=new UserService();
            Field field=clazz.getDeclaredField("userService");
            String result=field.getName();
            field.setAccessible(true);
            String setName="set"+result.substring(0,1).toUpperCase()+result.substring(1,result.length());
            //获去method
            Method  method=clazz.getDeclaredMethod(setName,UserService.class);
            method.setAccessible(true);
            Object o
            =method.invoke(person,userService);

            System.out.println(person.getUserService());
            //参数的class 对象
            System.out.println(field.getType());
            Field field1=clazz.getDeclaredField("name");
            System.out.println(field1.getType());
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
