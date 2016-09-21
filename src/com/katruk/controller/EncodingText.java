package com.katruk.controller;

public enum EncodingText {

    CP1251("CP1251"), Utf8("Utf8");

    String name;

    EncodingText(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
