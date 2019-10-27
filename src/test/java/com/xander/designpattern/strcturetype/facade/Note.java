package com.xander.designpattern.strcturetype.facade;

/**
 * 外观模式（Facade、门面模式）定义：是一种通过为多个复杂的子系统提供一个一致的接口，
 * 而使这些子系统更加容易被访问的模式。该模式对外有一个统一接口，
 * 外部应用程序不用关心内部子系统的具体的细节，这样会大大降低应用程序的复杂度，提高了程序的可维护性。
 *
 */
public class Note {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
