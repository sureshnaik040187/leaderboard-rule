package com.naik.league.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naik.league.controller.model.LeagueModel;
import com.naik.league.services.LeagueService;

@RestController
@RequestMapping(value ="/v1/", produces= "application/json")
public class LeagueController {

	@Autowired
	private LeagueService service;

	@PostMapping("league")
	public ResponseEntity getDetails(@RequestBody LeagueModel request) {
		if(StringUtils.isEmpty(request.getCountry_name()) ||
				StringUtils.isEmpty(request.getLeague_name()) ||
				StringUtils.isEmpty(request.getTeam_name()))
			return ResponseEntity.badRequest().body("Bad Request");
		LeagueModel response = service.getStandingForCountry(request);
		return ResponseEntity.ok().body(response);
	}
}
