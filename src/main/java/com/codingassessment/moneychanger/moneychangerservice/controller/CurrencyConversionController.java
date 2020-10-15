package com.codingassessment.moneychanger.moneychangerservice.controller;

import com.codingassessment.moneychanger.moneychangerservice.model.BuildAPIResponse;
import com.codingassessment.moneychanger.moneychangerservice.model.Currency;
import com.codingassessment.moneychanger.moneychangerservice.service.ExchangeCurrency;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/amount/{amount}")
    @ResponseBody
    public BuildAPIResponse getExchangedAmount(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount)
    {
        try {
            Currency currencyConverter = new ExchangeCurrency(1, "Exchanged Amount", from, to, amount);
            BigDecimal exchangedAmount= currencyConverter.getExchangedAmount(currencyConverter);
            System.out.println("calculated exchanged amount: + " + exchangedAmount);
            return new BuildAPIResponse("success", HttpStatus.OK, "200", new Date(),
                    exchangedAmount);
        }catch(Exception e){
            System.out.println("Error while calculating exchanged amount: "+e);
            return new BuildAPIResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "500", new Date(),
                    null);
        }
    }

    @GetMapping("/get-exchange-rate/from/{from}/to/{to}")
    @ResponseBody
    public BuildAPIResponse getExchangeRate(@PathVariable String from, @PathVariable String to)
    {
        try {
        Currency currencyConverter = new ExchangeCurrency(2,"Exchange Rate",from,to, null);
        BigDecimal exchangedRate= currencyConverter.getExchangeRate(currencyConverter);
        System.out.println("Exchanged Rate for "+from+" ->"+to+": + "+ exchangedRate);
        return new BuildAPIResponse("success", HttpStatus.OK, "200", new Date(),
                exchangedRate);
        }catch(Exception e){
            System.out.println("Error while getting exchange rate: "+e);
            return new BuildAPIResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "500", new Date(),
                    null);
        }
    }
}
