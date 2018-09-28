package com.paul.currencyconversionserviece;

import com.paul.currencyconversionserviece.entities.ConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service") to use API gateaway, need to update  URI as well to zulu form host:zuluPort/appName/URI
@FeignClient(name = "zulu-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    ConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}