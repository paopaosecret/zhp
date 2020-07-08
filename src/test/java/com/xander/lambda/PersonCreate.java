package com.xander.lambda;

/**
 * Created by zhaobing04 on 2020/7/8.
 */
@FunctionalInterface
public interface PersonCreate {
    Person create(int age, String name);
}
