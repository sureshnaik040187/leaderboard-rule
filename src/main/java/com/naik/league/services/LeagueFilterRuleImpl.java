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
public class LeagueFilterRuleImpl implements FilterRule<LeagueModel, Optional<LeagueModel>> {
    public static String ACTION_LEAGUES = "get_leagues";

    @Autowired
    ConfigProperties configProperties;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Optional<LeagueModel> process(LeagueModel leagueModel) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(configProperties.getUrl())
                .queryParam("action", ACTION_LEAGUES)
                .queryParam("country_id", leagueModel.getCountry_id())
                .queryParam("APIkey", configProperties.getApiKey());

        ResponseEntity<LeagueModel[]> response = restTemplate.getForEntity(builder.toUriString(), LeagueModel[].class);
        LeagueModel[] leagueData = response.getBody();
        Optional<LeagueModel> filterData = Arrays.stream(leagueData)
                .filter(data -> leagueModel.getCountry_id().equals(data.getCountry_id())
                        && leagueModel.getLeague_name().equals(data.getLeague_name())).findFirst();
        return filterData;
    }
}
