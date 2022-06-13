package com.example.billsplit;

public class Bills {

    private String bName;
    private int bAmount;

    public Bills(String bName, int bAmount) {
        this.bName = bName;
        this.bAmount = bAmount;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getbAmount() {
        return bAmount;
    }

    public void setbAmount(int bAmount) {
        this.bAmount = bAmount;
    }
}
