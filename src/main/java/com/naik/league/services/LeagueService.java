package com.naik.league.services;

import com.naik.league.controller.model.LeagueError;
import com.naik.league.controller.model.LeagueModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    private List<FilterRule> rulesList = null;

    @Autowired
    private CountryFilterRuleImpl countryFilterRule;

    @Autowired
    private LeagueFilterRuleImpl leagueFilterRule;

    @Autowired
    private StandingFilterRuleImpl standingFilterRule;

    public LeagueModel getStandingForCountry(LeagueModel request) {
        rulesList = new ArrayList<>();
        rulesList.addAll(Arrays.asList(countryFilterRule, leagueFilterRule, standingFilterRule));
        LeagueModel response = request;
        for (FilterRule filterRule : rulesList) {
           Optional<LeagueModel> filterData = (Optional<LeagueModel>) filterRule.process(request);
           filterData.orElseThrow(() -> new LeagueError("No data Found"));
           response.merge(filterData.get());
        }
        return response;
    }
}
