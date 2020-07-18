package com.naik.league.services;

import com.naik.league.configuration.ConfigProperties;
import com.naik.league.controller.model.LeagueModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)

public class LeagueServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ConfigProperties configProperties;

    @InjectMocks
    private LeagueService leagueService;

    @Before
    public void setup() {
        when(configProperties.getUrl()).thenReturn("testUrl");
        when(configProperties.getApiKey()).thenReturn("testKey");
    }

    @Test
    public void whenNoDataAvailableForRequest_shouldReturnEmpty() {
        LeagueModel leagueModel = new LeagueModel();
        when(restTemplate.getForEntity(Mockito.anyString(), Mockito.any())).thenReturn(ResponseEntity.of(Optional.of(new LeagueModel[0])));
        Optional<LeagueModel> response = leagueService.getStandingForCountry(leagueModel);
        Assert.assertThat(response.isPresent(), is(false));
        verify(restTemplate, times(1)).getForEntity(Mockito.anyString(), Mockito.any());
    }
}