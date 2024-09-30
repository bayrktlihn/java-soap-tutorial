package io.bayrktlihn.javasoaptutorial;

import io.bayrktlihn.javasoaptutorial.dto.response.CountryResponse;
import io.bayrktlihn.javasoaptutorial.service.CountryInfoServiceApplication;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JavaSoapTutorialApplication {
    public static void main(String[] args) {

        CountryInfoServiceApplication countryInfoServiceApplication = new CountryInfoServiceApplication();

        List<CountryResponse> allCountries = countryInfoServiceApplication.findAllCountries();


        for (CountryResponse allCountry : allCountries) {
            log.info(allCountry.toString());
        }

    }
}
