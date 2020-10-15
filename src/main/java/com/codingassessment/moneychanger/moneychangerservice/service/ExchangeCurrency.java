package com.codingassessment.moneychanger.moneychangerservice.service;

import com.codingassessment.moneychanger.moneychangerservice.model.Currency;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class ExchangeCurrency extends Currency {
    public ExchangeCurrency(int id, String name, String from, String to, BigDecimal amount) {
        super(id, name, from, to, amount);
    }

    public String getTo() {
        return to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public BigDecimal getExchangeRate(Currency currency) {

        BigDecimal exchangeRate = BigDecimal.ZERO;
        String GET_URL = "https://api.exchangeratesapi.io/latest?base=" +getTo()+ "&symbols="+getFrom();
        try {
            URL url = new URL(GET_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }in.close();

                JSONObject object = new JSONObject(response.toString());
                exchangeRate = object.getJSONObject("rates").getBigDecimal(getFrom());
                exchangeRate = exchangeRate.setScale(2, RoundingMode.HALF_EVEN);
            }
            else{
                System.out.println("GET request failed!");
            }
        } catch(Exception e){
                System.out.println("Exception occured while getting exchange rate value: "+ e);
        }
        return exchangeRate;
    }

    @Override
    public BigDecimal getExchangedAmount(Currency currency) {
        DecimalFormat decimalFormat = new DecimalFormat();
        BigDecimal exchangeRate = getExchangeRate(currency);
        BigDecimal exchangedAmount = BigDecimal.ZERO;
        try {
            exchangedAmount = getAmount().divide(exchangeRate, 2, RoundingMode.HALF_UP);
            System.out.println(decimalFormat.format(getAmount()) + getFrom() + "=" +
                    decimalFormat.format(getAmount().divide(exchangeRate, 2, RoundingMode.HALF_UP)) + getTo());
        }catch(Exception e){
            System.out.println("Exception occured while getting exchanged amount value: "+ e);
        }
        return exchangedAmount;
    }
}
