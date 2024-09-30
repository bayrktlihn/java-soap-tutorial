package io.bayrktlihn.javasoaptutorial.client;

import io.bayrktlihn.javasoaptutorial.LoggingHandler;
import org.oorsprong.websamples.ArrayOftCountryInfo;
import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.oorsprong.websamples.ObjectFactory;

import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.List;
import java.util.Properties;

public class CountryInfoServiceClient {

    private final ObjectFactory objectFactory = new ObjectFactory();

    private final CountryInfoService countryInfoService = new CountryInfoService();

    private final CountryInfoServiceSoapType countryInfoServiceSoapType = countryInfoService.getCountryInfoServiceSoap();


    {
        String property = System.getProperty("application.profile");


        Properties properties = System.getProperties();

        Object o = properties.get("application.profile");

        BindingProvider bindingProvider = (BindingProvider) countryInfoServiceSoapType;
        Binding binding = bindingProvider.getBinding();

        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LoggingHandler());
        binding.setHandlerChain(handlerChain);
    }


    public String languageName(String isoCode) {
        return countryInfoServiceSoapType.languageName(isoCode);
    }

    public ArrayOftCountryInfo fullCountryInfoAllCountries(){
        return countryInfoServiceSoapType.fullCountryInfoAllCountries();
    }


}
