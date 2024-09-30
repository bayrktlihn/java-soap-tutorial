package io.bayrktlihn.javasoaptutorial.service;

import io.bayrktlihn.javasoaptutorial.client.CountryInfoServiceClient;
import io.bayrktlihn.javasoaptutorial.dto.response.CountryResponse;
import io.bayrktlihn.javasoaptutorial.mapper.CountryMapper;
import org.oorsprong.websamples.ArrayOftCountryInfo;
import org.oorsprong.websamples.TCountryInfo;

import java.util.ArrayList;
import java.util.List;

public class CountryInfoServiceApplication {

    private final CountryInfoServiceClient countryInfoServiceClient = new CountryInfoServiceClient();
    private final CountryMapper countryMapper = new CountryMapper();

    public List<CountryResponse> findAllCountries() {
        ArrayOftCountryInfo arrayOftCountryInfo = countryInfoServiceClient.fullCountryInfoAllCountries();

        List<CountryResponse> result = new ArrayList<>();
        if (arrayOftCountryInfo != null) {
            List<TCountryInfo> tCountryInfo = arrayOftCountryInfo.getTCountryInfo();
            for (TCountryInfo countryInfo : tCountryInfo) {
                result.add(countryMapper.tCountryInfoToCountry(countryInfo));
            }
        }

        return result;
    }

}
