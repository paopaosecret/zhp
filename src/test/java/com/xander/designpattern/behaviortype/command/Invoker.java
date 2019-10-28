package com.xander.designpattern.behaviortype.command;

/**
 * Created by zhaobing04 on 2019/10/28.
 *
 *   调用者/请求者（Invoker）角色：持有命令对象，并调用命令执行
 */
public class Invoker {
    /**
     * 所持有的命令对象，可持有一组如：（List<ICommand></>）
     */
    private ICommand command;

    /**
     * 设置具体的命令
     * @param command
     */
    public void setCommand(ICommand command){
        this.command = command;
    }

    /**
     * 执行命令
     */
    public void execCommand(){
        command.execute();
    }
}
