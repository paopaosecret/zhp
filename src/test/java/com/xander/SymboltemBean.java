package com.xander;

import java.io.Serializable;

public class SymboltemBean implements Serializable {
    private String ask;
    private String answer;

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    //    private String symbol;
//
//    private String jumpUrl;
//
//    public String getSymbol() {
//        return symbol;
//    }
//
//    public void setSymbol(String symbol) {
//        this.symbol = symbol;
//    }
//
//    public String getJumpUrl() {
//        return jumpUrl;
//    }
//
//    public void setJumpUrl(String jumpUrl) {
//        this.jumpUrl = jumpUrl;
//    }
}
