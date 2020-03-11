package com.xander.threadtest.threadlocal;

/**
 * Created by zhaobing04 on 2019/12/27.
 */
public class HolderInteger {

    public HolderInteger(int value){
        this.value = value;
    }
    private int value;

    public int getValue(){
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private ThreadLocal<HolderInteger> mThreadLocal = new ThreadLocal(){
        @Override
        protected HolderInteger initialValue() {
//            System.out.println(Thread.currentThread().getName() + "：initialValue");
            return new HolderInteger(-1);
        }
    };

    public int getHolderInt(){
        return mThreadLocal.get().value;
    }

    public void setHolderInt(int value){
        mThreadLocal.get().setValue(value);
    }
}
