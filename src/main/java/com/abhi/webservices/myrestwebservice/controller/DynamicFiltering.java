package com.abhi.webservices.myrestwebservice.controller;

import com.abhi.webservices.myrestwebservice.model.PaymentInfo;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Abhinav on 2/24/2019.
 */
@RestController
public class DynamicFiltering {

    @GetMapping("/dynamic/filter/1")
    public MappingJacksonValue paymentDataWithoutCardDtl(){
        MappingJacksonValue filteredDtls = getMappingJacksonValue(SimpleBeanPropertyFilter.filterOutAllExcept("id", "amount"));
        return filteredDtls;
    }

    @GetMapping("/dynamic/filter/2")
    public MappingJacksonValue paymentDataWithCardDtl(){
        MappingJacksonValue filteredDtls = getMappingJacksonValue(SimpleBeanPropertyFilter.filterOutAllExcept("id", "amount", "cardNo"));
        return filteredDtls;
    }

    private MappingJacksonValue getMappingJacksonValue(SimpleBeanPropertyFilter simpleBeanPropertyFilter) {
        PaymentInfo paymentInfo = new PaymentInfo(123, 20.50, "1234-5678-4321-1234");
        MappingJacksonValue filteredDtls = new MappingJacksonValue(paymentInfo);
        SimpleBeanPropertyFilter propertyFilter = simpleBeanPropertyFilter;
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("paymentInfoFilter", propertyFilter);
        filteredDtls.setFilters(filterProvider);
        return filteredDtls;
    }

}
