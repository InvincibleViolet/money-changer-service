package com.codingassessment.moneychanger.moneychangerservice.model;

import java.math.BigDecimal;

public interface TradingCurrency {
    public BigDecimal getExchangeRate(Currency currency);
    public BigDecimal getExchangedAmount(Currency currency);
}
