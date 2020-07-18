package com.naik.league.services;

import com.naik.league.configuration.ConfigProperties;
import com.naik.league.controller.model.LeagueModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Optional;

@Component
public class CountryFilterRuleImpl implements FilterRule<LeagueModel, Optional<LeagueModel>> {

    public static String ACTION_COUNTRIES = "get_countries";

    @Autowired
    ConfigProperties configProperties;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Optional<LeagueModel> process(LeagueModel input) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(configProperties.getUrl())
                .queryParam("action", ACTION_COUNTRIES)
                .queryParam("APIkey", configProperties.getApiKey());

        ResponseEntity<LeagueModel[]> response = restTemplate.getForEntity(builder.toUriString(), LeagueModel[].class);
        LeagueModel[] leagueData = response.getBody();
        Optional<LeagueModel> filterData =  Arrays.stream(leagueData)
                .filter(data -> input.getCountry_name().equals(data.getCountry_name())).findFirst();
        return filterData;
    }
}
