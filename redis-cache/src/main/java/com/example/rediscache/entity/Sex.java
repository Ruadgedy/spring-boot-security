package com.example.rediscache.entity;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
public enum Sex {
    MALE(0, "男"), FEMALE(1, "女");

    private int sexCode;

    public int getSexCode() {
        return sexCode;
    }

    public void setSexCode(int sexCode) {
        this.sexCode = sexCode;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    private String sexName;

    Sex(int sexCode, String sexName){
        this.sexCode = sexCode;
        this.sexName = sexName;
    }

}
