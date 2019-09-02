package com.xander.designpattern.visitorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public class Computer implements ComputerPart {
    List<ComputerPart> parts = new ArrayList<>();
    public void add(ComputerPart part){
        parts.add(part);
    }

    public void remove(ComputerPart part){
        parts.remove(part);
    }

    @Override
    public void accept(ComputerVisitor visitor) {
        for(int i= 0; i < parts.size(); i++){
            parts.get(i).accept(visitor);
        }
    }
}
