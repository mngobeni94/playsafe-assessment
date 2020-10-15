package com.playsafe.assessment.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;

@RestController
@RequestMapping("/conversions")
public class ConversionController {

    ConversionService conversionService;

    @Autowired
    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("ktoc/{kelvin}")
    @LogMethodExecutionTime
    public ResponseEntity<BigDecimal> convertKelvinToCelsius(@PathVariable("kelvin") BigDecimal kelvin) {
        return ResponseEntity.ok(conversionService.ConvertKelvinToCelsius(kelvin));
    }

    @GetMapping("ctok/{celsius}")
    @LogMethodExecutionTime
    public ResponseEntity<BigDecimal> convertCelsiusToKelvin(@PathVariable("celsius") BigDecimal celsius) {
        return ResponseEntity.ok(conversionService.convertCelsiusToKelvin(celsius));
    }

}
