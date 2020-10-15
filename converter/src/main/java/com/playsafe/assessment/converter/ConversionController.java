package com.playsafe.assessment.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversions")
public class ConversionController {

    @Autowired
    public ConversionController(ConversionService conversionService) {
    }
}
