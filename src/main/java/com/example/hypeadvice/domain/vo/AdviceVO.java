package com.example.hypeadvice.domain.vo;


import java.util.Arrays;
import java.util.List;

public class AdviceVO {

    private Slip slip;

    public Slip getSlip() {
        return slip;
    }

    public void setSlip(Slip slip) {
        this.slip = slip;
    }

    public List<Slip> getSlips(){
        return Arrays.asList(slip);
    }

}
