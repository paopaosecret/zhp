package com.xander.lambda;

/**
 * Created by zhaobing04 on 2020/7/8.
 */
public class Person {
    public String name;
    public Integer age;

    public Person(){}

    public Person(Integer age,String name){
        this.name = name;
        this.age = age;
    }

    public static int compareByAge(Person a, Person b){
        return a.age.compareTo(b.age);
    }

    public String toString(){
        return
            "age = " + age +
            ", name = " + name;
    }
}
