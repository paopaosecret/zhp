package com.xander.threadtest.threadlocal;

/**
 * Created by zhaobing04 on 2019/12/30.
 */
public class HolderObject {
    public HolderObject(Data value){
        this.data = value;
    }
    private Data data;

    public Data getValue(){
        return data;
    }

    public void setValue(Data value) {
        this.data = value;
    }

    private ThreadLocal<Data> mThreadLocal = new ThreadLocal(){
        @Override
        protected Data initialValue() {
//            System.out.println(Thread.currentThread().getName() + "：initialValue");
            return new Data(-1, "null");
        }
    };

    public Data getHolderObj(){
        return mThreadLocal.get();
    }

    public void setHolderData(int id, String name){
        mThreadLocal.get().setId(id);
        mThreadLocal.get().setName(name);
    }
}
