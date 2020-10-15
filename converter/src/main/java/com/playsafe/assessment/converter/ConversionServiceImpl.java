package com.playsafe.assessment.converter;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConversionServiceImpl implements ConversionService {

    private static final BigDecimal KELVIN_CELSIUS_DIFF = new BigDecimal(273.15);

    private static final BigDecimal MILES_KILOMETER_RATIO = new BigDecimal(1.609344);

    @Override
    public BigDecimal ConvertKelvinToCelsius(BigDecimal kelvin) {
        return kelvin.subtract(KELVIN_CELSIUS_DIFF).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public BigDecimal convertCelsiusToKelvin(BigDecimal celsius) {
        return celsius.add(KELVIN_CELSIUS_DIFF).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public BigDecimal convertMilesToKilometers(BigDecimal miles) {
        return miles.multiply(MILES_KILOMETER_RATIO).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public BigDecimal convertKilometersToMiles(BigDecimal kilometers) {
        return kilometers.divide(MILES_KILOMETER_RATIO, 2, BigDecimal.ROUND_HALF_UP);
    }

}
