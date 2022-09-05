package com.example.hypeadvice.domain.vo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Slip {

    private Long id;
    private String advice;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Slip{" +
                "id=" + id +
                ", advice='" + advice + '\'' +
                ", date=" + date +
                '}';
    }
}
