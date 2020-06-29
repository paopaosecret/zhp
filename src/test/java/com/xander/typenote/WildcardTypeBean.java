package com.xander.typenote;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaobing04 on 2019/2/27.
 */
public class WildcardTypeBean<K extends Animal> {
    static class Bean{
        List<? extends Animal> dataList;
        Map<? extends Animal,? super Dog> dataMap;
    }

    public static void main(String[] args) {
        Field[] fields = Bean.class.getDeclaredFields();
        if(fields != null && fields.length > 0){
            for(Field field : fields){
                Type type = field.getGenericType();
                if(!(type instanceof ParameterizedType)){
                    System.out.println("字段：" + field.getName() + "---中不包含WildcardType类型\n");
                    continue;
                }
                ParameterizedType pt = ((ParameterizedType)type);
                Type[] types = pt.getActualTypeArguments();
                if(types != null && types.length > 0){
                    for(Type item : types){
                        if(item instanceof WildcardType){
                            Type[] types1 = ((WildcardType) item).getUpperBounds();
                            StringBuffer stringBuffer = new StringBuffer("");
                            if(types1 != null && types1.length > 0){
                                for(Type type1: types1){
                                    stringBuffer.append(type1.getTypeName() + "----");
                                }
                            }
                            System.out.println("字段：" + field.getName() +"---" + item.getTypeName() +  "---WildcardType.getUpperBounds() 返回：" + stringBuffer.toString());
                            Type[] types2 = ((WildcardType) item).getLowerBounds();
                            StringBuffer stringBuffer1 = new StringBuffer("");
                            if(types1 != null && types1.length > 0){
                                for(Type type1: types2){
                                    stringBuffer1.append(type1.getTypeName() + "----");
                                }
                            }
                            System.out.println("字段：" + field.getName() + "---" + item.getTypeName() + "---WildcardType.getLowerBounds() 返回：" + stringBuffer1.toString());

                        }else{
                            System.out.println("字段：" + field.getName() + " item--> " + item.getTypeName() +"---不是WildcardType类型\n");
                        }
                    }
                }
            }
        }

    }

}
