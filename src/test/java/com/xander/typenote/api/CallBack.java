package com.xander.typenote.api;

/**
 * Created by zhaobing04 on 2019/3/1.
 */
public interface CallBack<T extends Response,Q extends Request>{


    void before(Q reuqets);

    T execute(Q request);

    void after(T reponse, Q request);





}
