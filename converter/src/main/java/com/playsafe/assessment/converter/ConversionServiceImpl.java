package com.playsafe.assessment.converter;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConversionServiceImpl implements ConversionService {

    private static final BigDecimal KELVIN_CELSIUS_DIFF = new BigDecimal(273.15);

    @Override
    public BigDecimal ConvertKelvinToCelsius(BigDecimal kelvin) {
        return kelvin.subtract(KELVIN_CELSIUS_DIFF).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public BigDecimal convertCelsiusToKelvin(BigDecimal celsius) {
        return celsius.add(KELVIN_CELSIUS_DIFF).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
