package com.paul.currencyconversionserviece.controllers;

import com.paul.currencyconversionserviece.CurrencyExchangeProxy;
import com.paul.currencyconversionserviece.entities.ConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionControler {

    @Autowired
    private CurrencyExchangeProxy currencyExhchangeProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                         @PathVariable String quantity){

        Map<String, String> uriValriables = new HashMap<>();
        uriValriables.put("from", from);
        uriValriables.put("to", to);

        ResponseEntity<ConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                ConversionBean.class,
                uriValriables);

        ConversionBean response = responseEntity.getBody();
        BigDecimal quant = BigDecimal.valueOf(Long.valueOf(quantity));
        BigDecimal multiple = response.getConversionMultiple();
        return new ConversionBean(response.getId(), response.getFrom(), response.getTo(),
                multiple, quant, quant.multiply(multiple));
    }

    @GetMapping("/currency-converter/feign/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
                                          @PathVariable String quantity){

        ConversionBean response = currencyExhchangeProxy.retrieveExchangeValue(from, to);

        BigDecimal quant = BigDecimal.valueOf(Long.valueOf(quantity));
        BigDecimal multiple = response.getConversionMultiple();
        return new ConversionBean(response.getId(), response.getFrom(), response.getTo(),
                multiple, quant, quant.multiply(multiple));
    }

}
