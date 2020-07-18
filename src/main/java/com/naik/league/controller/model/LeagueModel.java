package com.naik.league.controller.model;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

public class LeagueModel {


	private String country_name;
	private String country_id;
	private String league_id;
	private String league_name;
	private String team_id;
	private String team_name;
	private String overall_league_position;


	public LeagueModel merge(LeagueModel objToMerge) {
		if(objToMerge == null)
			return this;
		this.country_id = objToMerge.country_id ==  null ? this.country_id : objToMerge.country_id;
		this.country_name = objToMerge.country_name ==  null ? this.country_name : objToMerge.country_name;
		this.league_id = objToMerge.league_id ==  null ? this.league_id : objToMerge.league_id;
		this.league_name = objToMerge.league_name ==  null ? this.league_name : objToMerge.league_name;
		this.team_id = objToMerge.team_id ==  null ? this.team_id : objToMerge.team_id;
		this.team_name = objToMerge.team_name ==  null ? this.team_name : objToMerge.team_name;
		this.overall_league_position = objToMerge.overall_league_position ==  null
				? this.overall_league_position : objToMerge.overall_league_position;
		return this;
	}

	@Override
	public String toString() {
		return "LeagueModel{" +
				"country_name='" + country_name + '\'' +
				", league_id='" + league_id + '\'' +
				", league_name='" + league_name + '\'' +
				", team_id='" + team_id + '\'' +
				", team_name='" + team_name + '\'' +
				", overall_league_position='" + overall_league_position + '\'' +
				'}';
	}

	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getLeague_id() {
		return league_id;
	}
	public void setLeague_id(String league_id) {
		this.league_id = league_id;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getOverall_league_position() {
		return overall_league_position;
	}
	public void setOverall_league_position(String overall_league_position) {
		this.overall_league_position = overall_league_position;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
}
