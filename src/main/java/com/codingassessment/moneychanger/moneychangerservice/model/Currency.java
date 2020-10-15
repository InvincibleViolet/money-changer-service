package com.codingassessment.moneychanger.moneychangerservice.model;

import java.math.BigDecimal;

public abstract class Currency implements TradingCurrency {
    public int id;
    public String name;
    public String from;
    public String to;
    public BigDecimal amount;

    public Currency(int id, String name, String from, String to, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}
