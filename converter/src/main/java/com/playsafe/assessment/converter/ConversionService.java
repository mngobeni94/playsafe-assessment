package com.playsafe.assessment.converter;

import java.math.BigDecimal;

public interface ConversionService {
    BigDecimal ConvertKelvinToCelsius(BigDecimal kelvin);

    BigDecimal convertCelsiusToKelvin(BigDecimal celsius);

    BigDecimal convertMilesToKilometers(BigDecimal miles);

    BigDecimal convertKilometersToMiles(BigDecimal kilometers);
}
