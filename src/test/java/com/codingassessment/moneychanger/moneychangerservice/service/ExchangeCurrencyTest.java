package com.codingassessment.moneychanger.moneychangerservice.service;

import com.codingassessment.moneychanger.moneychangerservice.model.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExchangeCurrencyTest {

    private ExchangeCurrency exchangeCurrencyUnderTest;

    @BeforeEach
    void setUp() {
        exchangeCurrencyUnderTest = new ExchangeCurrency(0, "name", "from", "to", new BigDecimal("0.00"));
    }

//    @Test
//    void testGetTo() {
//        // Setup
//
//        // Run the test
//        final String result = exchangeCurrencyUnderTest.getTo();
//
//        // Verify the results
//        assertEquals("result", result);
//    }

    @Test
    void testGetId() {
        // Setup

        // Run the test
        final int result = exchangeCurrencyUnderTest.getId();

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testSetId() {
        // Setup

        // Run the test
        exchangeCurrencyUnderTest.setId(0);

        // Verify the results
    }

//    @Test
//    void testGetName() {
//        // Setup
//
//        // Run the test
//        final String result = exchangeCurrencyUnderTest.getName();
//
//        // Verify the results
//        assertEquals("result", result);
//    }

    @Test
    void testSetName() {
        // Setup

        // Run the test
        exchangeCurrencyUnderTest.setName("name");

        // Verify the results
    }

//    @Test
//    void testGetFrom() {
//        // Setup
//
//        // Run the test
//        final String result = exchangeCurrencyUnderTest.getFrom();
//
//        // Verify the results
//        assertEquals("result", result);
//    }

    @Test
    void testGetAmount() {
        // Setup

        // Run the test
        final BigDecimal result = exchangeCurrencyUnderTest.getAmount();

        // Verify the results
        assertEquals(new BigDecimal("0.00"), result);
    }

    @Test
    void testSetAmount() {
        // Setup

        // Run the test
        exchangeCurrencyUnderTest.setAmount(new BigDecimal("0.00"));

        // Verify the results
    }

    @Test
    void testGetExchangeRate() {
        // Setup
        final Currency currency = new ExchangeCurrency(1,"Exchanged Amount","SGD","USD", BigDecimal.valueOf(1000));

        // Run the test
        final BigDecimal result = exchangeCurrencyUnderTest.getExchangeRate(currency);

        // Verify the results
        assertEquals(new BigDecimal("0"), result);
    }

    @Test
    void testGetExchangedAmount() {
        // Setup
        final Currency currency = new ExchangeCurrency(1,"Exchanged Amount","SGD","USD", BigDecimal.valueOf(1000));

        // Run the test
        final BigDecimal result = exchangeCurrencyUnderTest.getExchangedAmount(currency);

        // Verify the results
        assertEquals(new BigDecimal("0"), result);
    }
}
