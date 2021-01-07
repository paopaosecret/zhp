package com.xander.compile.zcompile.语法分析;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaobing04 on 2020/11/30.
 * 基于//README.MD中定义的语言实现语法分析过程
 * 语法分析：依据语法规则，编写语法分析程序，把 Token 串转化成 AST
 */
public class Grammar {
    public static void main(String[] args) {
        List<String> tokenizer = Arrays.asList("num", "add", "a", "b", "c", "{" , "num",
                "temp", "=" , "10" , "*", "a", "+", "b", "*", "c", ";", "return", "temp", ";", "}");
        FunctionNote functionNote = new FunctionNote();
        functionNote.paramNotes = new ArrayList<>();
        boolean startFlag = false;
        boolean endFlag = false;
        int retValue = -1;
        Expression tempExpression = new Expression();
        for(int i = 0; i< tokenizer.size(); i++){
            if(tokenizer.get(i).equals("{")){
                startFlag = true;
                continue;
            }
            if(tokenizer.get(i).equals("}")){
                endFlag = true;
            }
            if(i == 0){
                functionNote.retType = tokenizer.get(0);
                continue;
            }else if(i == 1){
                functionNote.name = tokenizer.get(1);
                continue;
            }else {

                if(endFlag){
                    System.out.println(JSON.toJSONString(functionNote));
                    break;
                }
                if(startFlag){
                    if(!tokenizer.get(i).equals(";")){
                        tempExpression.opList.add(tokenizer.get(i));
                    }else{
                        functionNote.body.expressionList.add(Expression.copy(tempExpression));
                        tempExpression = new Expression();
                    }
                }else{
                    ParamNote paramNote = new ParamNote();
                    paramNote.name = tokenizer.get(i);
                    functionNote.paramNotes.add(paramNote);
                    continue;
                }

            }

        }
    }


    /**
     * Created by zhaobing04 on 2020/11/30.
     */
    static class Expression implements Serializable {
        List<String> opList = new ArrayList<>();
        public List<String> getOpList() {
            return opList;
        }

        public void setOpList(List<String> opList) {
            this.opList = opList;
        }

        public static Expression copy(Expression expression){
            String json = JSON.toJSONString(expression);
            Expression temp = JSON.parseObject(json, Expression.class);
            return temp;
        }
    }

    /**
     * Created by zhaobing04 on 2020/11/30.
     */
    static class FunctionBody implements Serializable {
        List<Expression> expressionList = new ArrayList<>();

        public List<Expression> getExpressionList() {
            return expressionList;
        }

        public void setExpressionList(List<Expression> expressionList) {
            this.expressionList = expressionList;
        }
    }

    /**
     * Created by zhaobing04 on 2020/11/30.
     */
    static class ParamNote implements Serializable {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * Created by zhaobing04 on 2020/11/30.
     */
    static class FunctionNote implements Serializable{
        String name;
        String retType;
        List<ParamNote> paramNotes;
        FunctionBody body = new FunctionBody();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRetType() {
            return retType;
        }

        public void setRetType(String retType) {
            this.retType = retType;
        }

        public List<ParamNote> getParamNotes() {
            return paramNotes;
        }

        public void setParamNotes(List<ParamNote> paramNotes) {
            this.paramNotes = paramNotes;
        }

        public FunctionBody getBody() {
            return body;
        }

        public void setBody(FunctionBody body) {
            this.body = body;
        }
    }
}

