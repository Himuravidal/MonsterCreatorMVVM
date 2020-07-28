package com.crisspian.monstercreator_mvvm.model;

import androidx.annotation.NonNull;

public class AttributeValue {
    private String name = "";
    private int value = 0;

    public AttributeValue(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " " + name + ", valor=" + value;
    }
}
