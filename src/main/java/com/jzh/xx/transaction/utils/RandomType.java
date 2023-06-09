package com.jzh.xx.transaction.utils;

public enum RandomType {
    INT("0123456789"),
    STRING("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"),
    ALL("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");

    private final String factor;
    private static final String INT_STR = "0123456789";
    private static final String STR_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALL_STR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String getFactor() {
        return this.factor;
    }

    private RandomType(final String factor) {
        this.factor = factor;
    }
}
