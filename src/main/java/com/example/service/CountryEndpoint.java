package com.example.service;

import com.example.api.GetCountryRequest;
import com.example.api.GetCountryResponse;
import com.example.repository.CountryRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://com.company.api";

    private final CountryRepository repository;

    public CountryEndpoint(CountryRepository repository) {
        this.repository = repository;
    }

    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(repository.findCountry(request.getName()));
        return response;
    }
}
