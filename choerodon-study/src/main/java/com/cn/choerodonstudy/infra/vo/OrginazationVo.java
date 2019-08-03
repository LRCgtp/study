package com.cn.choerodonstudy.infra.vo;

import java.math.BigInteger;

public class OrginazationVo {
    private BigInteger ID;
    private String NAME;
    private String CODE;
    private Integer IS_ENABLED;

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public Integer getIS_ENABLED() {
        return IS_ENABLED;
    }

    public void setIS_ENABLED(Integer IS_ENABLED) {
        this.IS_ENABLED = IS_ENABLED;
    }

    @Override
    public String toString() {
        return "OrginazationVo{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", CODE='" + CODE + '\'' +
                ", IS_ENABLED=" + IS_ENABLED +
                '}';
    }
}
