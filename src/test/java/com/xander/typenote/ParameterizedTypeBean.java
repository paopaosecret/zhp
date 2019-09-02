package com.xander.typenote;

import java.util.List;
import java.util.Map;

/**
 * Created by zhaobing04 on 2019/2/14.
 */
public class ParameterizedTypeBean {
    Map<String, Animal> map;
    Map.Entry<String, String> entry;
    List aList;

    static class Holder<V> {

    }
}
