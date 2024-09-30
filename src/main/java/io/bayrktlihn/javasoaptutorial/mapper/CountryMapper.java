package io.bayrktlihn.javasoaptutorial.mapper;

import io.bayrktlihn.javasoaptutorial.dto.response.CountryResponse;
import org.oorsprong.websamples.TCountryInfo;

public class CountryMapper {

    public CountryResponse tCountryInfoToCountry(TCountryInfo tCountryInfo) {
        CountryResponse countryResponse = new CountryResponse();
        countryResponse.setCapital(tCountryInfo.getSCapitalCity());
        countryResponse.setName(tCountryInfo.getSName());
        countryResponse.setPhoneCode(tCountryInfo.getSPhoneCode());
        return countryResponse;
    }

}
